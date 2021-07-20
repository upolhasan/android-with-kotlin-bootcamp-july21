# 🖥 Lab 8: Validating Inputs and Restoring State
Let's add state restoration and input validation to our app.

## Objectives
1. Ensure `Fragment` state is preserved on rotation by checking for empty saved state before setting initial `BottomNavigationView` item
2. Add a Save button to `CreateNoteFragment`
3. Hide the Save button until all three fields have input
4. If Save button is clicked with an invalid title, display an error using `TextInputLayout`
5. If Save button is clicked with invalid content, display an error using `TextInputLayout`
6. When Save button is clicked with valid inputs, display a "success" `Snackbar` and dismiss the `Fragment`
7. Show a `Toast` when opening `NoteDetailFragment`

## Challenges
1. Within `CreateNoteFragment`, save a value to the `Bundle` in `onSaveInstanceState()`.  Then, in `onViewCreated()`, check if that value is available in the `Bundle` and show it as a `Toast`.  Then, use the techniques we discussed to explore which situations trigger state restoration.