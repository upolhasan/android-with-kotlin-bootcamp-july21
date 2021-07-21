# 🖥 Lab 15: Implementing MVVM Using Android Architecture Components
Let's apply MVVM architecture to our app using Android Architecture Components

## Objectives
1. Create `MyNotesViewModel` class that extends `ViewModel`
2. Create a repository class for interacting with our database from the `ViewModel`   
    1. Create `NotesRepository` interface
    2. Create `RoomNotesRepository` class to implement `NotesRepository`
    3. Add `NotesRepository` as a constructor property of `MyNotesViewModel`
3. Setup `ViewModel` property in `MyNotesFragment`
    1. Create a `MyNotesViewModelFactory` class that extends `ViewModelProvider.Factory`
    2. Use `MyNotesViewModelFactory` in `MyNotesFragment` to acquire a Fragment-scoped `ViewModel` using the `by viewModels()` property delegate (see notes)
4. Load notes from the database within the `init{}` block of the `ViewModel`
    1. We will use this load to update our UI state
5. Create `MyNotesViewModel.ViewState` class to represent UI state
    1. This will be used to bind into our adapter in `MyNotesFragment`
6. Expose a `val viewState: LiveData<ViewState>` property from your `ViewModel`
    1. This will be observed by `MyNotesFragment` to update the adapter
7. Modify `MyNotesListAdapter` to support list updating by converting it to extend `ListAdapter`
8. Within `MyNotesFragment.onCreateView()` observe `MyNotesViewModel.viewState` and update the adapter anytime a new view state is observed
9. Update `MyNotesViewModel` to support outgoing and incoming events
    1. Create `Effect` and `Action` sealed classes to represent outgoing and incoming events
    2. Expose a `val effects: Flow<Effect>` property from your `ViewModel`
    3. Collect `MyNotesViewModel.effects` within `MyNotesFragment.onCreate()` to process effects
    4. Move calls to `navigate()` into the effects collection
    5. Call `MyNotesViewModel.onEvent()` in response to click events

## Challenges
1. Apply this architecture to `NoteDetailFragment`
2. Apply this architecture to `CreateNoteFragment`