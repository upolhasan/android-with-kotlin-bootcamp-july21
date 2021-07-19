package dev.goobar.androidbootcampwithkotlinlab3.sealedclasses

import dev.goobar.androidbootcampwithkotlinlab3.sealedclasses.SupportedAndroidLanguageException.EmptyNameException
import dev.goobar.androidbootcampwithkotlinlab3.sealedclasses.SupportedAndroidLanguageException.InvalidNameException
import dev.goobar.androidbootcampwithkotlinlab3.sealedclasses.isSupportedAndroidLangauge
import org.junit.Test

class SealedClassTests {

  @Test(expected = InvalidNameException::class)
  fun `verify javascript is not supported`() {
    isSupportedAndroidLangauge("javascript")
  }

  @Test(expected = EmptyNameException::class)
  fun `verify blank name is not supported`() {
    isSupportedAndroidLangauge("")
  }

  @Test(expected = EmptyNameException::class)
  fun `verify empty name is not supported`() {
    isSupportedAndroidLangauge("  ")
  }

  @Test
  fun `verify kotlin is supported`() {
    assert(isSupportedAndroidLangauge("Kotlin"))
  }

  @Test
  fun `verify java is supported`() {
    assert(isSupportedAndroidLangauge("java"))
  }
}