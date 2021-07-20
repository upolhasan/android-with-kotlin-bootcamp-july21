package dev.goobar.androidstudyguidejuly21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

    val detailButton: Button = view.findViewById(R.id.showNoteDetailsButton)
    detailButton.setOnClickListener {
      findNavController().navigate(R.id.action_myNotesFragment_to_noteDetailFragment)
    }

    return view
  }
}