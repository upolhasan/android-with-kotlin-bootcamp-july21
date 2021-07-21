package dev.goobar.androidstudyguidejuly21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.data.SAMPLE_NOTES
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesListAdapter

class MyNotesFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_my_notes, container, false)

    val floatingActionBtton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
    floatingActionBtton.setOnClickListener {
      findNavController().navigate(R.id.action_myNotesFragment_to_createNoteFragment)
    }

    val notesList: RecyclerView = view.findViewById(R.id.notesList)
    notesList.layoutManager = LinearLayoutManager(requireContext())
    notesList.adapter = MyNotesListAdapter(SAMPLE_NOTES) { note ->
      findNavController()
        .navigate(
          R.id.action_myNotesFragment_to_noteDetailFragment,
          NoteDetailFragment.buildBundle(note)
        )
    }

    return view
  }
}