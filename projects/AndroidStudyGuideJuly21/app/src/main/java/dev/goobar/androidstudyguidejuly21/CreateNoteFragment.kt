package dev.goobar.androidstudyguidejuly21

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.internal.TextWatcherAdapter
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.datastore.defaultCategoryDataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.w3c.dom.Text

private val REQUEST_CHOOSE_IMAGE = 0
private val CATEGORIES = listOf("Tooling", "Kotlin", "UI", "Navigation", "Misc")

class CreateNoteFragment : Fragment() {

  private lateinit var titleEditText: EditText
  private lateinit var contentEditExt: EditText
  private lateinit var noteImageView: ImageView
  private lateinit var categorySpinner: Spinner

  private var noteId: Int? = null
  private var uriToImage: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    noteId = CreateNoteFragment.parseBundle(arguments)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_create_note, container, false)

    noteImageView = view.findViewById(R.id.imageView)
    val saveButton: FloatingActionButton = view.findViewById(R.id.saveButton)
    titleEditText = view.findViewById(R.id.titleEditText)
    val titleInputLayout: TextInputLayout = view.findViewById(R.id.titleInputContainer)
    contentEditExt = view.findViewById(R.id.noteEditText)
    val contentInputLayout: TextInputLayout = view.findViewById(R.id.noteInputContainer)

    titleEditText.addTextChangedListener(object : TextWatcherAdapter() {
      override fun afterTextChanged(s: Editable) {
        // respond to changes in the title
        titleInputLayout.error = null
        // if both title and content are not empty, show the save button
        if (areInputsValid()) {
          saveButton.show()
        } else {
          saveButton.hide()
        }
      }
    })

    contentEditExt.addTextChangedListener(object : TextWatcherAdapter() {
      override fun afterTextChanged(s: Editable) {
        // respond to changes in the title
        contentInputLayout.error = null
        // if both title and content are not empty, show the save button
        if (areInputsValid()) {
          saveButton.show()
        } else {
          saveButton.hide()
        }
      }
    })

    saveButton.setOnClickListener {
      if (areInputsValid()) {
        if(isEdit()) updateNote() else saveNote()

        val snackbar = Snackbar.make(requireView(), "Saved the note!", Snackbar.LENGTH_SHORT)
        snackbar.addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
          override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            super.onDismissed(transientBottomBar, event)
            if (lifecycle.currentState.isAtLeast(State.STARTED)) {
              findNavController().popBackStack()
            }
          }
        })
        snackbar.show()
        return@setOnClickListener
      }

      if (titleEditText.text.isBlank()) {
        titleInputLayout.error = "Title must not be blank"
      }
      if (contentEditExt.text.isBlank()) {
        contentInputLayout.error = "Content must not be blank"
      }
    }

    categorySpinner = view.findViewById(R.id.categorySpinner)
    categorySpinner.adapter = CategorySpinnerAdapter(requireContext(), CATEGORIES)
    categorySpinner.onItemSelectedListener = object : OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        lifecycleScope.launch {
          requireContext().defaultCategoryDataStore.updateData { defaultCategory ->
            defaultCategory.toBuilder().setCategory(CATEGORIES[position]).build()
          }
        }
      }

      override fun onNothingSelected(parent: AdapterView<*>?) {}

    }

    noteImageView.setOnClickListener {
      selectImage()
    }

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val id = noteId

    if (id == null) {
      lifecycleScope.launchWhenCreated {
        requireContext().defaultCategoryDataStore.data.collect { defaultCategory ->
          categorySpinner.setSelection(CATEGORIES.indexOf(defaultCategory.category))
        }
      }
    } else {
      lifecycleScope.launch {
        val note = requireActivity().studyGuideApplication().database.noteDao().get(id)

        titleEditText.setText(note.title)
        categorySpinner.setSelection(CATEGORIES.indexOf(note.category))
        contentEditExt.setText(note.content)
        note.imageUri?.let { uri ->
          uriToImage = uri
          noteImageView.setImageURI(Uri.parse(uri))
        }
      }
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if(requestCode != REQUEST_CHOOSE_IMAGE || resultCode == Activity.RESULT_CANCELED) return

    if (resultCode == Activity.RESULT_OK && data != null) {
      val contentResolver = requireContext().contentResolver
      val takeFlags: Int = Intent.FLAG_GRANT_READ_URI_PERMISSION
      contentResolver.takePersistableUriPermission(data.data!!, takeFlags)

      uriToImage = data.data.toString()
      noteImageView.setImageURI(data.data)
    }
  }

  private fun isEdit() = noteId != null

  private fun updateNote() {
    val newNoteId = noteId ?: return

    val title = titleEditText.text.toString()
    val category = CATEGORIES[categorySpinner.selectedItemPosition]
    val content = contentEditExt.text.toString()
    val image = uriToImage

    val newNote = Note(title, category, content, image).apply {
      id = newNoteId
    }

    lifecycleScope.launch {
      requireActivity().studyGuideApplication().database.noteDao().update(newNote)
    }
  }

  private fun saveNote() {
    val title = titleEditText.text.toString()
    val category = CATEGORIES[categorySpinner.selectedItemPosition]
    val content = contentEditExt.text.toString()
    val image = uriToImage

    lifecycleScope.launch {
      val database = requireActivity().studyGuideApplication().database
      database.noteDao().save(Note(title, category, content, image))
    }
  }

  private fun areInputsValid(): Boolean {
    return titleEditText.text.isNotBlank() && contentEditExt.text.isNotBlank()
  }

  private fun selectImage() {
    val intent = Intent().apply {
      type = "image/*"
      action = Intent.ACTION_OPEN_DOCUMENT
    }
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CHOOSE_IMAGE)
  }

  companion object {
    private const val EXTRA_NOTE_ID = "key_note_id"

    fun buildEditBundle(note: Note) = Bundle().apply {
      putInt(EXTRA_NOTE_ID, note.id)
    }

    private fun parseBundle(bundle: Bundle?): Int? {
      val id = bundle?.getInt(EXTRA_NOTE_ID, -1)
      return if(id == -1) null else id
    }
  }
}

class CategorySpinnerAdapter(context: Context, items: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {
  init {
    addAll(items)
  }
}