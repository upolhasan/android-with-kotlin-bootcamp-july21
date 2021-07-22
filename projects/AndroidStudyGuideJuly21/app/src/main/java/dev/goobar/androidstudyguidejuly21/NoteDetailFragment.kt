package dev.goobar.androidstudyguidejuly21

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dev.goobar.androidstudyguidejuly21.data.Note
import kotlinx.coroutines.launch

class NoteDetailFragment : Fragment() {

  private lateinit var note: Note

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_note_detail, container, false)

    val noteId = parseBundle(requireArguments())

    val noteTitle: TextView = view.findViewById(R.id.noteTitleTextView)
    val noteCategory: TextView = view.findViewById(R.id.noteCategoryTextView)
    val noteContent: TextView = view.findViewById(R.id.noteContentTextView)
    val noteImage: ImageView = view.findViewById(R.id.noteImageView)
    val editButton: FloatingActionButton = view.findViewById(R.id.editButton)
    val deleteButton: FloatingActionButton = view.findViewById(R.id.deleteButton)

    editButton.setOnClickListener {
      editNote(note)
    }

    deleteButton.setOnClickListener {
      deleteNote(note)
    }

    lifecycleScope.launchWhenCreated {

      note = requireActivity()
        .studyGuideApplication()
        .database
        .noteDao()
        .get(noteId)

      noteTitle.text = note.title
      noteCategory.text = note.category
      noteContent.text = note.content
      if (note.imageUri != null) {
        noteImage.setImageURI(Uri.parse(note.imageUri))
      }
    }

    return view
  }

  private fun editNote(note: Note) {
    findNavController().navigate(
      R.id.action_noteDetailFragment_to_createNoteFragment,
      CreateNoteFragment.buildEditBundle(note)
    )
  }

  private fun deleteNote(note: Note) {
    lifecycleScope.launch {
      requireActivity().studyGuideApplication().database.noteDao().delete(note)
      Snackbar.make(requireView(), "Note deleted", Snackbar.LENGTH_SHORT).show()
      findNavController().popBackStack()
    }
  }

  companion object {
    private const val EXTRA_NOTE_ID = "key_note_id"

    fun buildBundle(note: Note) = Bundle().apply {
      putInt(EXTRA_NOTE_ID, note.id)
    }

    fun parseBundle(bundle: Bundle): Int {
      val noteId = bundle.getInt(EXTRA_NOTE_ID)
      checkNotNull(noteId)
      return noteId
    }
  }
}