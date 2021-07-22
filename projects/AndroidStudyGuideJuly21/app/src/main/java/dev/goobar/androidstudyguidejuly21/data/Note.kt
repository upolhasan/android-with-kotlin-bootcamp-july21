package dev.goobar.androidstudyguidejuly21.data

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

val SAMPLE_NOTES = listOf(
  Note("RecyclerView Info", "UI", "RecyclerView is efficient at showing many items on the screen."),
  Note("Sample Note 2", "General", "Some sample content"),
  Note(
    title = "Kotlin is neat",
    category = "Kotlin",
    content = """Kotlin has a lot of great language features that were not previously available to Android developers.
Features such as non-null types, extension functions, data classes, and higher-order functions.
       """.trimIndent()
  ),
  Note("Sample Note 4", "Tooling", "Some sample content"),
  Note("Sample Note 5", "UI", "Some sample content"),
  Note("Sample Note 6", "Tooling", "Some sample content"),
  Note("Sample Note 7", "General", "Some sample content"),
  Note("Sample Note 8", "Kotlin", "Some sample content"),
  Note("Sample Note 9", "Kotlin", "Some sample content"),
  Note("Sample Note 10", "Misc", "Some sample content"),
  Note("Sample Note 11", "General", "Some sample content"),
  Note("Sample Note 12", "General", "Some sample content"),
  Note("Sample Note 13", "General", "Some sample content"),
)

@Entity
data class Note(
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "category") val category: String,
  @ColumnInfo(name = "content") val content: String,
  @ColumnInfo(name = "image_uri") val imageUri: String? = null
) {

  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
}
