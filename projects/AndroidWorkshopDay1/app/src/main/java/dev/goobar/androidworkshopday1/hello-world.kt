package dev.goobar.androidworkshopday1

import android.util.Log

fun buildGreeting(greeting: String) = "$greeting World!"


fun helloWorld(greeting: String): Unit {
  println(buildGreeting(greeting))
}

fun main() {
  helloWorld("Hey 👋")
}