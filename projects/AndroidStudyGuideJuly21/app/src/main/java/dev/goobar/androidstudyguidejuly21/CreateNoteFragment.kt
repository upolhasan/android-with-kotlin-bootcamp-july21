package dev.goobar.androidstudyguidejuly21

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner

class CreateNoteFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_create_note, container, false)

    val categorySpinner: Spinner = view.findViewById(R.id.categorySpinner)
    categorySpinner.adapter = CategorySpinnerAdapter(requireContext())

    return view
  }
}

class CategorySpinnerAdapter(context: Context) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {
  init {
    addAll("Tooling", "Kotlin", "UI", "Navigation", "Misc")
  }
}