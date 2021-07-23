# 🖥 Lab 19 Hints: Using WorkManager for Background Tasks

## 💡 Helpful Resources
- [WorkManager Basics](https://developer.android.com/topic/libraries/architecture/workmanager/basics)

## 💡 What GitHub url should I use to upload my note file?
You should use a URL to any repo to which you can generate an access token.

The path to that repo should then be specified as
`https://api.github.com/repos/<username>/<repo>/contents/$filename`

ex: `https://api.github.com/repos/goobar-dev/workshop-sample-data/contents/$filename`

## 💡 How do I pass my Note data to my Worker?
We can pass data to a `Worker` using the `androidx.work.Data` class. This class functions very similar to a `Bundle`.

Within `NoteUploadWorker`, create a companion object to help build and parse a `Data` object for passing the `Note` data.

```kotlin
companion object {
    private const val KEY_CONTENT = "key_content"
    private const val KEY_FILENAME = "filename"

    fun buildInputData(note: Note): Data = workDataOf(
      KEY_FILENAME to "uploaded-notes/${note.title}-${System.currentTimeMillis()}.txt",
      KEY_CONTENT to encodeNote(note)
    )

    fun parseInputData(data: Data): NoteUploadConfig {
      return NoteUploadConfig(data.getString(KEY_FILENAME)!!, data.getString(KEY_CONTENT)!!)
    }

    private fun encodeNote(note: Note): String {
      val noteContent = note.title + "\n" + note.category + "\n" + note.content
      return Base64.encodeToString(noteContent.toByteArray(), android.util.Base64.DEFAULT)
    }
  }

  data class NoteUploadConfig(val filename: String, val content: String)
```

## 💡 How do I submit an upload request to GitHub?
```kotlin
private fun uploadFileData(context: Context, filename: String, content: String) {
    val requestQueue = Volley.newRequestQueue(context)
    
    val body = JSONObject().apply {
      put("message", "Upload from app") // commit message of file upload to GitHub
      put("content", content) 
    }
    
    val request =  object : JsonObjectRequest(
      Method.PUT,
      "url to your repo",
      body,
      { 
          // handle success
          Toast.makeText(context, "Successfully uploaded note", Toast.LENGTH_SHORT).show()
      },
      {
          // handle error
          Toast.makeText(context, "Failed to upload note", Toast.LENGTH_SHORT).show()
      }
    ) {
      override fun getHeaders(): MutableMap<String, String> {
        return mutableMapOf(
          "Authorization" to "token <your repo access token>",
          "Accept" to "application/vnd.github.v3+json"
        )
      }
    }
    
    requestQueue.add(request)
}
```