# 🖥 Lab 20 Hints: Integrating a Web App into Your Application

## 💡 Helpful Resources
- [Android WebView Guide](https://developer.android.com/guide/webapps/webview)
- [Enabling Javascript in a WebView](https://developer.android.com/guide/webapps/webview#EnablingJavaScript)
- [Connecting Javascript to Kotlin](https://developer.android.com/guide/webapps/webview#BindingJavaScript)  
- [Android WebView Docs](https://developer.android.com/reference/android/webkit/WebView)
- [How we built Twitter Lite](https://blog.twitter.com/engineering/en_us/topics/open-source/2017/how-we-built-twitter-lite)

## 💡 How to load Twitter's PWA into a WebView?
```kotlin
fun WebView.loadTwitter() {
  loadUrl("https://mobile.twitter.com")
}
```

## 💡 How to load Twitter's PWA into a WebView directly to the Composer
```kotlin
/**
 * Will load Twitter's PWA "Twitter Lite" and open up to the composer with a set of pre-populated
 * hashtags
 */
fun WebView.loadTwitterComposer(vararg hashtags: String) {
  val formattedHashtags = hashtags.toList().reduceRightIndexed { index, s, acc ->
    val separator = if(index == hashtags.size -1) "" else ","
    acc + separator + s
  }
  loadUrl("https://mobile.twitter.com/intent/tweet?hashtags=$formattedHashtags")
}
```

## 💡 Where can I find some simple HTML/Javascript to load into my WebView?
Look no further!

Ensure that you've added the `SimpleWebAppInterface` class to yor project.
Then, add the `WebView.loadSimpleWebApp()` extension function and invoke it after setting up your `WebView`   in `onCreate()`

The created instance of `SimpleWebAppInterface` will be used to connect to click handlers defined in the Javascript

```kotlin
/**
 * Basic example of a Kotlin -> Javascript bridging implementation
 */
class SimpleWebAppInterface(private val activity: Activity) {

    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun navigateBack() {
        activity.finish()
    }
}

/**
 * Will load some basic html/javascript with a bridging class to communicate back to the Activity
 */
fun WebView.loadSimpleWebApp(activity: Activity) {
  addJavascriptInterface(SimpleWebAppInterface(activity), "SimpleWebAppInterface")

  val html = """
      <!DOCTYPE html>
      <html>
      <head>
      <style>
      body {background-color: powderblue;}
      h1   {color: blue;}
      p    {color: red;}
      </style>
      </head>
      <body>
      
      <input type="button" value="Say hello" onClick="showAndroidToast('Hello Android!')" />
      <input type="button" value="Finish" onClick="navigateBack()" />
      <h1>Simple Web App</h1>
      <p>Connect HTML/Javascript elements to our mobile app</p>
      </body>
      
      <script type="text/javascript">
          function showAndroidToast(toast) {
              SimpleWebAppInterface.showToast(toast);
          }
          
          function navigateBack() {
              SimpleWebAppInterface.navigateBack();
          }
      </script>
      
      </html>
    """.trimIndent()
  val encodedHtml = Base64.encodeToString(html.toByteArray(), Base64.NO_PADDING)
  loadData(encodedHtml, "text/html", "base64")
}
```