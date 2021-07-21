package dev.goobar.androidstudyguidejuly21

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.internal.TextWatcherAdapter
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

private val REQUEST_CHOOSE_IMAGE = 0

class CreateNoteFragment : Fragment() {

  private lateinit var titleEditText: EditText
  private lateinit var contentEditExt: EditText
  private lateinit var noteImageView: ImageView

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
        val snackbar = Snackbar.make(requireView(), "Saved the note!", Snackbar.LENGTH_SHORT)
        snackbar.addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
          override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            super.onDismissed(transientBottomBar, event)
            requireActivity().supportFragmentManager.popBackStack()
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

    val categorySpinner: Spinner = view.findViewById(R.id.categorySpinner)
    categorySpinner.adapter = CategorySpinnerAdapter(requireContext())

    noteImageView.setOnClickListener {
      selectImage()
    }

    return view
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if(requestCode != REQUEST_CHOOSE_IMAGE || resultCode == Activity.RESULT_CANCELED) return

    if (resultCode == Activity.RESULT_OK && data != null) {
      val uriToImage = data.data
      noteImageView.setImageURI(uriToImage)
    }
  }

  private fun areInputsValid(): Boolean {
    return titleEditText.text.isNotBlank() && contentEditExt.text.isNotBlank()
  }

  private fun selectImage() {
    val intent = Intent().apply {
      type = "image/*"
      action = Intent.ACTION_GET_CONTENT
    }
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CHOOSE_IMAGE)
  }
}

class CategorySpinnerAdapter(context: Context) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {
  init {
    addAll("Tooling", "Kotlin", "UI", "Navigation", "Misc")
  }
}