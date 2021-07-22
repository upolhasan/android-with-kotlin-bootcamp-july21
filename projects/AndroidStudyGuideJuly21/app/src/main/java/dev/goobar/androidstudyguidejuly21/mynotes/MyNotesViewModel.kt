package dev.goobar.androidstudyguidejuly21.mynotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.goobar.androidstudyguidejuly21.data.Note
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Action.CreateButtonClicked
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Action.NoteClicked
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Effect.ShowCreateNoteScreen
import dev.goobar.androidstudyguidejuly21.mynotes.MyNotesViewModel.Effect.ShowNoteDetails
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MyNotesViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MyNotesViewModel::class.java)) {
      return MyNotesViewModel(repository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }

}

class MyNotesViewModel(private val repository: NotesRepository) : ViewModel() {

  override fun onCleared() {
    super.onCleared()
    viewModelScope.cancel()
  }

  private val _viewState: MutableLiveData<ViewState> = MutableLiveData(ViewState())
  val viewState: LiveData<ViewState> = _viewState

  private val _effects: MutableSharedFlow<Effect> = MutableSharedFlow()
  val effects: SharedFlow<Effect> = _effects

  init {
    viewModelScope.launch {
      repository.getNotes().collect { newNotes ->
        _viewState.value = ViewState(newNotes)
      }
    }
  }

  fun onAction(action: Action) {
    when (action) {
      CreateButtonClicked -> {
        viewModelScope.launch { _effects.emit(ShowCreateNoteScreen) }
      }
      is NoteClicked -> {
        viewModelScope.launch { _effects.emit(ShowNoteDetails(action.note)) }
      }
    }
  }

  data class ViewState(val notes: List<Note> = listOf())

  sealed class Action {
    object CreateButtonClicked: Action()
    data class NoteClicked(val note: Note): Action()
  }

  sealed class Effect {
    object ShowCreateNoteScreen: Effect()
    data class ShowNoteDetails(val note: Note): Effect()
  }
}