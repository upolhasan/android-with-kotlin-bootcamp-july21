package dev.goobar.androidstudyguidejuly21.utils

import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.mynotes.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EmptyNotesRepository(private val notes: List<Note> = listOf()) : NotesRepository {
  override fun getNotes(): Flow<List<Note>> = flowOf(notes)

  override suspend fun getNote(id: Int): Note {
    TODO("Not yet implemented")
  }

  override suspend fun saveNote(note: Note) {
    TODO("Not yet implemented")
  }

  override suspend fun updateNote(note: Note) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteNote(note: Note) {
    TODO("Not yet implemented")
  }

}