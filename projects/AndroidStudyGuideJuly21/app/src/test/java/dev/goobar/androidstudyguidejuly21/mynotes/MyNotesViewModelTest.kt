package dev.goobar.androidstudyguidejuly21.mynotes

import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.utils.CoroutinesTestRule
import dev.goobar.androidstudyguidejuly21.utils.EmptyNotesRepository
import dev.goobar.androidstudyguidejuly21.utils.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class MyNotesViewModelTest {

  @get:Rule
  var instantExecutorRule = InstantTaskExecutorRule()

  @get:Rule
  val coroutinesDispatcherRule = CoroutinesTestRule()

  private val mainThreadSurrogate = newSingleThreadContext("UI thread")

  @Before
  fun setUp() {
    Dispatchers.setMain(mainThreadSurrogate)
  }

  @After
  fun tearDown() {
    Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
    mainThreadSurrogate.close()
  }

  @Test
  fun `verify initial ViewState`() = runBlocking {
    val viewModel = MyNotesViewModel(EmptyNotesRepository())

    assertEquals(viewModel.viewState.value, MyNotesViewModel.ViewState())
  }

  @Test
  fun `verify ViewState on loaded notes`() = runBlocking {
    val viewModel = MyNotesViewModel(
      EmptyNotesRepository(
        listOf(Note("title", "category", "content"))
      )
    )

    val viewState = viewModel.viewState.getOrAwaitValue()

    assertEquals(
      MyNotesViewModel.ViewState(listOf(Note("title", "category", "content"))),
      viewState
    )
  }

}