# 🖥 Lab 15 Hints: Implementing MVVM Using Android Architecture Components

## 💡 Helpful Resources
- [Getting Started with Android Jetpack](https://developer.android.com/jetpack/getting-started)
- [Guide to App Architecture](https://developer.android.com/jetpack/guide)
- [Drive UI from Model](https://developer.android.com/jetpack/guide#drive-ui-from-model)
- [ViewModel Overview](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)  
- [StateFlow and SharedFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)

## 💡 My effects are being processed multiple times
When collecting a `Flow` in your UI layer (`Activity`/`Fragment`) make sure you are calling collect fromo within a `launchWhenStarted{}` block within `onCreate()`

## 💡 How do I create a ViewModelFactory when scoping my ViewModel?
When using `by viewModels{}` we may need to provide a custom factory if we need to pass parameters to our `ViewModel`.

To do this, we can extend `ViewModelProvider.Factory` and create a custom factory to manage the creation of our `ViewModel`
```kotlin
class MyNotesViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MyNotesViewModel::class.java)) {
      return MyNotesViewModel(repository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}

// from within your Fragment~~~~
/**
 * Provides a [MyNotesViewModel] scoped to the lifecycle of this fragment
 * This means that this view model will persist across configuration changes and view creation/destruction
 */
private val viewModel: MyNotesViewModel by viewModels<MyNotesViewModel> {
    MyNotesViewModelFactory(RoomNotesRepository(requireActivity().studyGuideApplication().database.noteDao()))
}
```
