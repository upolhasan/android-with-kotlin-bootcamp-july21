package dev.goobar.androidstudyguidejuly21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.data.SAMPLE_NOTES
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesListAdapter
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Action.CreateButtonClicked
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Action.NoteClicked
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Effect.ShowCreateNoteScreen
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Effect.ShowNoteDetails
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModelFactory
import dev.goobar.androidstudyguidejuly21.mynotes.RoomNotesRespository
import kotlinx.coroutines.flow.collect

class MyNotesFragment : Fragment() {

  private val viewModel: MyNotesViewModel by viewModels<MyNotesViewModel> {
    val dao = requireActivity().studyGuideApplication().database.noteDao()
    MyNotesViewModelFactory(RoomNotesRespository(dao))
  }

  private lateinit var adapter: MyNotesListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    lifecycleScope.launchWhenCreated {
      viewModel.effects.collect { effect ->
        when (effect) {
          ShowCreateNoteScreen -> {
            findNavController().navigate(R.id.action_myNotesFragment_to_createNoteFragment)
          }
          is ShowNoteDetails -> {
            findNavController().navigate(
              R.id.action_myNotesFragment_to_noteDetailFragment,
              NoteDetailFragment.buildBundle(effect.note)
            )
          }
        }
      }
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_my_notes, container, false)

    val floatingActionBtton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
    floatingActionBtton.setOnClickListener {
      viewModel.onAction(CreateButtonClicked)
    }

    val notesList: RecyclerView = view.findViewById(R.id.notesList)
    notesList.layoutManager = LinearLayoutManager(requireContext())
    adapter = MyNotesListAdapter() { note ->
      viewModel.onAction(NoteClicked(note))
    }
    notesList.adapter = adapter

    viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
      adapter.submitList(viewState.notes)
    }

    return view
  }
}