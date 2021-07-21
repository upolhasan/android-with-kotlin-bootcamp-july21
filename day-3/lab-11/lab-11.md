# 🖥 Lab 11: Displaying List Data with RecyclerView
Let’s update our app to display a hardcoded list of data in `MyNotesFragment`

## Objectives
1. Define a data class to represent a `Note`
2. Remove `noteDetailButton` from `fragment_my_notes.xml`
3. Add a `RecyclerView` to `fragment_my_note.xml`
4. Get a reference to your `RecyclerView` in `MyNotesFragment`
5. Create `item_note.xml` to represent individual `Note` list items in the UI
6. Create a `NoteViewholder` class that will bind view references from `item_note.xml` and bind `Note`s into the view
7. Create a `MyNotesListAdapter` class to convert a `List<Note>` into views for the `RecyclerView`
8. Set a `LinearLayoutManager` to your `RecyclerView`
9. Create an instance of `MyNotesListAdapter` and set it into your `RecyclerView`
10. Respond to list item selections by showing `NoteDetailFragment`
     1. Pass a function to your `MyNotesListAdapter` to respond to list item clicks
     2. In `MyNotesListAdapter,onBindViewHolder()` add a click listener to the item view by calling `setOnClickListener{}`
     3. Within the `View`'s click listener, call back into the click listener passed to the adapter
11. Pass the selected `Note` to `NoteDetailFragment` when item is selected
    1. Add `id 'kotlin-parcelize'` to the `plgins{}` block of `app/build.gradle`    
    2. Update `Note` to implement `Parcelable` and add `@Parcelize` annotation to the class
    3. Update the signature of your adapter's click listener function so that it takes a single `Note` argument
    4. Within `MyNotesListAdapter,onBindViewHolder()` update the `ViewHolder`'s click listener to pass the selected `Note` to the click listener by using the selected item position to lookup the `Note` from the list passed to the adapter
    5. 

## Challenges
1. Set list layout preview in `fragment_my_notes.xml`
2. Update `NoteDetailFragment` to display passed `Note` data
3. Update `NoteViewHolder` to display all `Note` data
4. Add touch feedback to your list items