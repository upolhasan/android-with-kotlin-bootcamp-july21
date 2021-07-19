package dev.goobar.androidbootcampwithkotlinlab3.functions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FunctionTests {
  private val standardOut: PrintStream = System.out
  private val outputStreamCaptor: ByteArrayOutputStream = ByteArrayOutputStream()

  @Before
  fun setUp() {
    System.setOut(PrintStream(outputStreamCaptor))
  }

  @Test
  fun `verify default values`() {
    helloWorld()

    Assert.assertEquals(
      "Hello World",
      outputStreamCaptor.toString().trim()
    )
  }

  @Test
  fun `verify named arguments order`() {
    helloWorld(
      thingToGreet = "World!",
      greeting = "Hello"
    )

    Assert.assertEquals(
      "Hello World!",
      outputStreamCaptor.toString().trim()
    )
  }

  @Test
  fun `verify named arguments`() {
    helloWorld(
      thingToGreet = "Kotlin",
      greeting = "Yay!"
    )

    Assert.assertEquals(
      "Yay! Kotlin",
      outputStreamCaptor.toString().trim()
    )
  }

  @Test
  fun `verify higher order function`() {
    helloHigherOrderFunctions {
      "Kotlin!!!"
    }

    Assert.assertEquals(
      "Hello Kotlin!!!",
      outputStreamCaptor.toString().trim()
    )
  }
}