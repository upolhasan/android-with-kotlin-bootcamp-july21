# 🖥 Lab 17 Hints: Downloading and Parsing JSON Data Using Volley

## 💡 Helpful Resources
- [Json Validation Tool](https://jsonlint.com/)
- [Volley Overview Guide](https://developer.android.com/training/volley)
- [Request Json w/ Volley](https://developer.android.com/training/volley/request#request-json)
- [Parse Json Arrays w/ Moshi](https://github.com/square/moshi#parse-json-arrays)

## 💡 How to make a Volley request for JsonArray data?
```kotlin
val jsonObjectRequest =  JsonArrayRequest(
    Request.Method.GET, 
    "<url to json array>",
    null,
    Response.Listener<JSONArray> {},
    Response.ErrorListener {}
)

Volley.newRequestQueue(requireContext()).add(jsonObjectRequest)
```

## 💡 How to parse a JsonArray using Moshi?
Say you have a `JsonArray` containing Json for a `Topic` type.
You could write a parse function that looks something like this.

```kotlin
private fun parseResponse(response: JSONArray): List<Topic> {
    val moshi = Builder().build()
    val type: Type = Types.newParameterizedType(MutableList::class.java, Topic::class.java)
    val adapter: JsonAdapter<List<Topic>> = moshi.adapter(type)
    return adapter.fromJson(response.toString()) ?: throw JSONException("Could not parse Topic list")
}
```

## 💡 My app crashes when I try to make the network request.  It says I don't have permissions.
To make a network request, our app must declare the `INTERNET` permission.
To declare the permission, add it in `AndroidManifest.xml`

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="dev.goobar.androidstudyguide">

  <uses-permission android:name="android.permission.INTERNET"/>

  <application
      ...
  </application>

</manifest>
```