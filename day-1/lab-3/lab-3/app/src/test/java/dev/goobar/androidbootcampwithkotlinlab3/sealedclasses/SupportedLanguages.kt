package dev.goobar.androidbootcampwithkotlinlab3.sealedclasses

sealed class SupportedAndroidLanguageException : Throwable() {
  // Implement additional types as-needed to pass the tests
}

private val supportedLanguages = listOf ("c++", "kotlin", "java")
fun isSupportedAndroidLangauge(language: String): Boolean {
  TODO("Implement the method to pass the tests")
}