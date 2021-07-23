package dev.goobar.androidstudyguidejuly21

import org.junit.Assert
import org.junit.Test

class TextUtilsTest {
  @Test
  fun `verify empty email is not valid`() {
    Assert.assertFalse(isEmail(""))
  }
}