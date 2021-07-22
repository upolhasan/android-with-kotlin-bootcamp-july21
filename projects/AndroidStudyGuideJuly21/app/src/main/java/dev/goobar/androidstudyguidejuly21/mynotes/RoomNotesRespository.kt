package dev.goobar.androidstudyguidejuly21.mynotes

import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.db.NoteDao
import kotlinx.coroutines.flow.Flow

class RoomNotesRespository(private val noteDao: NoteDao) : NotesRepository {
  override fun getNotes(): Flow<List<Note>> = noteDao.getAll()

  override suspend fun getNote(id: Int): Note = noteDao.get(id)

  override suspend fun saveNote(note: Note)  = noteDao.save(note)

  override suspend fun updateNote(note: Note) = noteDao.update(note)

  override suspend fun deleteNote(note: Note) = noteDao.delete(note)
}