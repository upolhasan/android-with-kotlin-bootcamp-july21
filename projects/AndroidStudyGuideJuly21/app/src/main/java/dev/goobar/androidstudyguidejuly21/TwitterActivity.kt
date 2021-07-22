package dev.goobar.androidstudyguidejuly21

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URLEncoder

class TwitterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_twitter)

    startActivity(createTweetIntent())
    finish() // finish this Activity so it doesn't stay in the Task stack
  }

  private fun createTweetIntent(): Intent {
    val tweetUrl = String.format(
      "https://twitter.com/intent/tweet?text=%s",
      URLEncoder.encode("I'm learning a lot about #androiddev today!", "UTF-8")
    )

    return Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl))
  }
}