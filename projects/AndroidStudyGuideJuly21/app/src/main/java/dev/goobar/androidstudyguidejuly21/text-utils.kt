package dev.goobar.androidstudyguidejuly21

fun isEmail(email: String): Boolean  = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();