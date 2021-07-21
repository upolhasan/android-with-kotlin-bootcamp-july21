# 🖥 Lab 14: Building a CRUD Working Using Room

## 💡 Helpful Resources 
- [Save data in a local database using Room](https://developer.android.com/training/data-storage/room)

## 💡 What dependencies will I need for this lab?
Room has a lot of optional dependencies depending on what functionality you want/need.

For this lab, you should only need the following additions
```groovy
plugins {
   ...
    id "org.jetbrains.kotlin.kapt"
}

// Room dependencies
def room_version = "2.3.0"

implementation("androidx.room:room-runtime:$room_version")
kapt("androidx.room:room-compiler:$room_version")
implementation("androidx.room:room-ktx:$room_version")
```

## 💡 How can we use a data class for our Room data model, while also having an auto-incrementing id property?
If we want our Room model data class to have an auto-incrementing id that is not managed by us, then we can't put the property in the constructor.
But if we can't put the data class property in the constructor, where can we put it?

Well, we can still add properties to a data class that are outside the constructor.
The only caveat, is that those properties won't be considered as part of the auto-generated equals/hashcode & copy() methods

```kotlin
@Entity
data class Note(
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "category") val category: String,
  @ColumnInfo(name = "content") val content: String,
  @ColumnInfo(name = "imageUri") val imageUri: String? = null
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
}
```

## 💡 If we are using suspend, and Flow as part of our Dao, how do we call those methods from a Fragment?
Because `suspend` and `Flow` are part of the Kotlin coroutines package, we must sometimes call those methods from a coroutine.

From within a Fragment, the best place to start is to call `lifecycleScope.launch {}` and perform any coroutine executions within the `launch{}` lambda.
We'll dive deeper into coroutines in Day 4.

## 💡 My app crashes when trying to display imageUri on app restart
As part of Android's recent permissions updates, new versions of Android must request persistent permissions to Uris from public folders.

This means, that after you retrieve an image Uri in `onActivityResult()` you must call the following code so that your app will still have permission to view the file on next launch

```kotlin
// refreshes permissions for the image URI
// required on Android 11+ due to scoped storage changes
val contentResolver = requireContext().contentResolver
val takeFlags: Int = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
contentResolver.takePersistableUriPermission(uri, takeFlags)
```