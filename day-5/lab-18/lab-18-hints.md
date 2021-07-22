# 🖥 Lab 18 Hints: Implementing a Service for Background Upload

## 💡 Helpful Resources
- [Services Overview](https://developer.android.com/guide/components/services)
- [GitHub Contents Api](https://docs.github.com/en/rest/reference/repos#contents)
- [Create GitHub Personal Access Token](https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token)

## 💡 What is the needed structure of the url for GitHub content upload?
`https://api.github.com/repos/<your username or org name>/<repo name>/contents/<name of file to upload>"`

## 💡 How do I make a GitHub file upload request using Volley
```kotlin
val requestQueue = Volley.newRequestQueue(this)

val body = JSONObject()
body.put("message", "<your desired commit message>") // commit message of file upload to GitHub
body.put("content", noteContent)

val request =  object : JsonObjectRequest(
  Method.PUT,
  "<your upload url>",
  body,
  {
    // handle success
  },
  {
    // handle error
  }
) {
  override fun getHeaders(): MutableMap<String, String> {
    return mutableMapOf(
      "Authorization" to "token <your token>",
      "Accept" to "application/vnd.github.v3+json"
    )
  }
}

requestQueue.add(request)
```

## 💡 How do I Base64 encode my Note data for upload?
Android has some utility methods for Base64 encoding.  We can leverage those.

```kotlin
val noteContent = note.title + "\n" + note.category + "\n" + note.content
return Base64.encodeToString(noteContent.toByteArray(), android.util.Base64.DEFAULT)
```

## 💡 Why am I getting a 404 when making my upload request to GitHub
You might need to double check that you are authenticating your request.

Ensure that you're adding a valid GitHub access token as a header to your request.

To do that with Volley, override the `getHeaders()` method of your `JsonObjectRequest`
```kotlin
override fun getHeaders(): MutableMap<String, String> {
    return mutableMapOf(
      "Authorization" to "token <your token here>"
    )
}
```