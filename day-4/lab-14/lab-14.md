# 🖥 Lab 14: Building a CRUD Working Using Room
Let's add support for creating, retrieving, updating, and deleting custom notes.

## Objectives
1. Add Room dependencies (see hints)
2. Update `Note` model to be a Room `@Entity`
    1. Can remove the @Parcelize setup as we will no longer pass `Note` directly but instead load it from DB
3. Create `NoteDao` interface with the following methods
    1. `fun getAll(): Flow<List<Note>>`
    2. `suspend fun get(noteId: Int): Note`
    3. `suspend fun insert(note: Note)`
    4. `suspend fun update(note: Note)`
    5. `suspend fun delete(note: Note)`
    6. You will need to annotate these methods with the appropriate Room annotations
4. Create `AppDatabase` class to access `NoteDao` and interact with the database
5. Make `AppDatabase` globally available by creating a public, lazy property on the `AndroidStudyGuideApplication` class
6. Create an extension function on `Activity` for easy access to `AndroidStudyGuideApplication`
    1. This will require casting `Activity.application` to `AndroidStudyGuideApplication

Once you have access to the database, it's time to implement our CRUD workflow across our application.
We'll update our app to support the following
- Displaying saved notes (from `MyNotesFragment`)
- Saving notes to the database (from `CreateNoteFragment`)
- Deleting a saved note (from `NoteDetailFragment`)
- Editing a saved note (from `CreateNoteFragment`)

7. Update `MyNotesFragment` to populate `MyNotesListAdapter` based on items saved to the database
8. Update `CreateNoteFragment` to save a `Note` to the database
9. Update `NoteDetailFragment` to load `Note` data from the database based on a passed note id
10. Update `NoteDetailFragment` to include a "Delete" and an "Edit" button
    1. "Delete" should delete the current `Note` from the database and return to the home screen
    2. "Edit" should navigate to `CreateNoteFragment` and pass `Note.id` so `CreateNoteFragment` can update the current note when saved
11. Update `CreateNoteFragment` to support loading a `Note` based on id and updating that `Note` when save is clicked

## Challenges
1. Update the navigation from `NoteDetailFragment` to `CreateNoteFragment` so that when you hit back from `CreateNoteFragment` the user returns to the home screen rather than to `NoteDetailFragment`
2. Update `NoteDetailFragment` to display `Note.imageUri`
3. Update `MyNotesListAdapter` to display `Note.imageUri`