package dev.goobar.androidstudyguidejuly21.twitter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import dev.goobar.androidstudyguidejuly21.R
import dev.goobar.androidstudyguidejuly21.R.layout
import java.net.URLEncoder

class TwitterActivity : AppCompatActivity() {

  lateinit var webView: WebView
  lateinit var progressBar: ProgressBar


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_twitter)

    progressBar = findViewById(R.id.progressBar)
    webView = findViewById(R.id.webView)

    startActivity(createTweetIntent())
    finish()

//    webView.settings.javaScriptEnabled = true
//    webView.webChromeClient = ProgressChromeClient(progressBar)

//    try these options 1 at a time
//    webView.loadTwitter()
//    webView.loadTwitterComposer("androiddev", "android")
//    webView.loadSimpleWebApp(this)
  }

  /**
   * Show Twitter composer via Intent
   * Should allow user to view Twitter either via the browser, or by any Twitter client that have
   * available that responds to the standard Twitter intent system.
   */
  private fun createTweetIntent(): Intent {
    // Create intent using ACTION_VIEW and a normal Twitter url:
    val tweetUrl = String.format(
      "https://twitter.com/intent/tweet?text=%s",
      URLEncoder.encode("I'm learning a lot about #androiddev today!", "UTF-8")
    )
    return Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl))
  }
}