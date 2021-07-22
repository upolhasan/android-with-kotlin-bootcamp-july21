package dev.goobar.androidstudyguidejuly21.mynotes

import dev.goobar.androidstudyguidejuly21.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
  fun getNotes(): Flow<List<Note>>
  suspend fun getNote(id: Int): Note
  suspend fun saveNote(note: Note)
  suspend fun updateNote(note: Note)
  suspend fun deleteNote(note: Note)
}