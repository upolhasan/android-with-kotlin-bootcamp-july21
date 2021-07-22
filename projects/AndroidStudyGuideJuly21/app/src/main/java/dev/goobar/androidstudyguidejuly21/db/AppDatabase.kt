package dev.goobar.androidstudyguidejuly21.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.goobar.androidstudyguidejuly21.data.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun noteDao(): NoteDao
}