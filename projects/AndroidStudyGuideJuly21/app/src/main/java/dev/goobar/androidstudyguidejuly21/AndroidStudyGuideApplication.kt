package dev.goobar.androidstudyguidejuly21

import android.app.Activity
import android.app.Application
import androidx.room.Room
import dev.goobar.androidstudyguidejuly21.db.AppDatabase

fun Activity.studyGuideApplication(): AndroidStudyGuideApplication = application as AndroidStudyGuideApplication

class AndroidStudyGuideApplication : Application() {

  val database: AppDatabase by lazy {
    Room.databaseBuilder(this, AppDatabase::class.java, "app-database").build()
  }

}