package dev.goobar.androidworkshopday1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  val TAG = MainActivity::class.java.simpleName

  private val targetScore = 20
  private var currentScore = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val targetText = findViewById<TextView>(R.id.targetTextView)
    val currentText = findViewById<TextView>(R.id.currentPointsTextView)
    val plus1Button = findViewById<Button>(R.id.plus1Button)
    val resetButton = findViewById<Button>(R.id.resetButton)

    targetText.text = "Target: $targetScore"
    currentText.text = "Current: $currentScore"

    plus1Button.setOnClickListener {
      currentScore++
      currentText.text = "Current: $currentScore"

      if (currentScore >= (targetScore - 5)) {
        currentText.setTextColor(getColor(android.R.color.holo_green_light))
      }

      if (currentScore == targetScore) {
        Toast.makeText(this, "You Won!!!", Toast.LENGTH_SHORT).show()
        resetButton.visibility = View.VISIBLE
      }
    }

    resetButton.setOnClickListener {
      currentScore = 0
      currentText.text = "Current: $currentScore"
      resetButton.visibility = View.GONE
    }
  }
}