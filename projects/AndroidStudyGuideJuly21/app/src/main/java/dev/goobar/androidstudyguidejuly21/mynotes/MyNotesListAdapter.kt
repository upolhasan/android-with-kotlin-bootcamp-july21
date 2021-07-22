package dev.goobar.androidstudyguidejuly21.mynotes

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.goobar.androidstudyguidejuly21.R
import dev.goobar.androidstudyguidejuly21.data.Note

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  val title: TextView = view.findViewById(R.id.titleTextView)
  val category: TextView = view.findViewById(R.id.categoryText)
  val content: TextView = view.findViewById(R.id.contentText)
  val image: ImageView = view.findViewById(R.id.noteImage)

  fun bindNode(note: Note) {
    title.text = note.title
    category.text = note.category
    content.text = note.content
    if (note.imageUri != null) {
      image.setImageURI(Uri.parse(note.imageUri))
    }
  }
}

class MyNotesListAdapter(
  private val notes: List<Note>,
  private val noteClickHandler: (Note) -> Unit
  ) : RecyclerView.Adapter<NoteViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    val noteView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
    return NoteViewHolder(noteView)
  }

  override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    val note = notes[position]
    holder.bindNode(note)
    holder.itemView.setOnClickListener { noteClickHandler(note) }
  }

  override fun getItemCount(): Int {
    return notes.size
  }
}