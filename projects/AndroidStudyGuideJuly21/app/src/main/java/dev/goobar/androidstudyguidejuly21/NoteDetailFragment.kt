package dev.goobar.androidstudyguidejuly21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import dev.goobar.androidstudyguidejuly21.data.Note

class NoteDetailFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_note_detail, container, false)

    val note = parseBundle(requireArguments())

    val noteTitle: TextView = view.findViewById(R.id.noteTitleTextView)
    val noteCategory: TextView = view.findViewById(R.id.noteCategoryTextView)
    val noteContent: TextView = view.findViewById(R.id.noteContentTextView)

    noteTitle.text = note.title
    noteCategory.text = note.category
    noteContent.text = note.content

    return view
  }

  companion object {
    private const val EXTRA_NOTE = "key_note"

    fun buildBundle(note: Note) = Bundle().apply {
      putParcelable(EXTRA_NOTE, note)
    }

    fun parseBundle(bundle: Bundle): Note {
      val note: Note? = bundle.getParcelable(EXTRA_NOTE)
      checkNotNull(note)
      return note
    }
  }
}