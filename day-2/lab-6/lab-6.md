# 🖥 Lab 6: Building a Complex User Interface

## Objectives
1. Add a custom `Toolbar` to `MainActivity`
    1. Change `Theme.AndroidStudyGuide` to extend `DarkActionBar` to `NoActionBar`
    2. Add a `Toolbar` `View` to `activity_main.xml`
    3. Set the `Toolbar` title to `"Android Study Guide"`
2. Add an overflow menu to the `Toolbar` that includes an option for showing `TwitterActivity`
    1. Create a new `Menu` resource named `main_toolbar.xml`
    2. Call `Toolbar.inflatMenu()` to add the `Menu` to the `Toolbar`
    3. Implement `Toolbar.setOnMenuItemClickListener()` to respond to clicking the menu item by showing `TwitterActivity`
    4. Remove the previously added Twitter button
3. Update `MainActivity` to use a `BottomNavigationView` to display `MyNotesFragment` and `StudyGuideFragment`
    1. Add `BottomNavigationView` to bottom of `activity_main.xml`
    2. Create a new `Menu` resource named `navigation_items.xml` that includes 2 items; 1 for "Notes" and 1 for "Guide"
    3. Set the items into the `BottomNavigtionView` using `app:menu="@menu/navigation_items"`
    4. Re-constrain `fragmentContainer` so that if fits between the `Toolbar` and `BottomNavigationView`
    5. In `MainActivity`, implement `BottomNavigationView.setOnItemSelectedListener()` to show `MyNotesFragment` and `StudyGuideFragment` when the corresponding tab is clicked
    6. Ensure `MyNotesFragment` is initially shown by calling `bottomNav.selectedItemId = R.id.myNotes` after setting up the item click listener
4. Prepare `MyNotesFragment` for future interactions
    1. Add a `FloatingActionButton` that shows `CreateNoteFragment` when clicked
    2. Add a `Button` that shows `NoteDetailFragment` when clicked
5. Now that all `Fragments` can be reached without them, remove remaining buttons from `activity_main.xml`
6. Setup basic note creation UI for `CreateNoteFragment`
    1. Add a `TextInputLayout` for collecting a note title from the user
    2. Add a `Spinner` for selecting note category and pre-populate it with you desired note categories
    3. Add a `TextInputLayout` for collecting the note content from th user
7. Setup basic note detail UI for `NoteDetailFragment` 
    1. Add a `TextView` for displaying the note title
    2. Add a `TextView` for displaying the note category
    3. Add a `TextView` for displaying the note content

## Challenges
1. Setup `View` references for each view in the created `Fragments`
2. Update your `TextInputLayout`s to use the `Outlined` theme so they look a nicer