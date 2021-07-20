# 🖥 Lab 8 Hints: Validating Inputs and Restoring State

## 💡 Helpful Resources
- [Toasts Overview](https://developer.android.com/guide/topics/ui/notifiers/toasts)
- [Using Snackbars](https://developer.android.com/training/snackbar/showing#display)
- [An Overview of UI State Restoration](https://developer.android.com/topic/libraries/architecture/saving-states)
- [Options for Preserving State](https://developer.android.com/topic/libraries/architecture/saving-states#options)
- [TextInputLayout Docs](https://developer.android.com/reference/com/google/android/material/textfield/TextInputLayout)

## 💡 How to show an error with TextInputLayout?
`TextInputLayout` can animate into a styled error message by setting calling `setError(msg)`.  Check out [the documentation](https://developer.android.com/reference/com/google/android/material/textfield/TextInputLayout#setError(java.lang.CharSequence)) for more on customizing the error message.

## 💡 How to validate that a String is not blank?
Kotlin has a number of helpful methods for checking the contents of a `String`
- `isBlank()`
- `isEmpty()`
- `isNotBlank()`
- `isNullOrBlank()`

## 💡 How to hide a View?
You can hide a `View` by setting `view.visibility = View.GONE`.

You can show it again by setting `view.visibility = View.VISIBLE`