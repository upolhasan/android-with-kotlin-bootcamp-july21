# 🖥 Lab 11 Hints: Displaying List Data with RecyclerView

## 💡 Helpful Resources
- [Create dynamic lists with RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [Efficient RecyclerView Updates with ListAdapter](https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter)
- [Customizing list item touch feedback](https://developer.android.com/training/material/animations#Touch)
- [GridLayoutManager](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/GridLayoutManager)
- [Efficient data serialization with Parcelable](https://developer.android.com/reference/android/os/Parcelable)
- [Simplify Parcelable implementation with @Parcelize Plugin](https://developer.android.com/kotlin/parcelize)

## 💡 How to pass a Note to my NoteDetailsFragment?
We can pass a `Bundle` to any call to `NavController.navigate()`.
Within that bundle, we can include simple arguments, or more complex types that implement `Parcelable`.

Because our `Note` class implements `Parcelable` we can add it to a `Bundle`, pass it to `navigate()` and then access the `Note` from `NoteDetailsFragment` when it's created.

To help create this `Bundle` we can add a companion object to `NoteDetailsFragment` that includes a `buildBundle(note: Note)` method.
We can then use the returned `Bundle` to pass to `navigate()`.

```kotlin
companion object {
    private const val EXTRA_NOTE = "note"

    fun buildBundle(note: Note) = Bundle().apply {
      putParcelable(EXTRA_NOTE, note)
    }

    private fun parseBundle(bundle: Bundle): Note {
      val note: Note? = bundle.getParcelable(EXTRA_NOTE)
      checkNotNull(note)
      return note
    }
  }
```

## How to access arguments passed to a Fragment?
To access the arguments passed to a `Fragment` call `requireArguments()` within `Fragment.onCreateView()`
You can then access individual passed arguments by calling typed getters such as `getParcelable("key")`

```kotlin
val note: Note? = requireArguments().getParcelable(EXTRA_NOTE)
```

## 💡 How to add a simple ripple animation when I select my list item?
Try adding `android:foreground="?attr/selectableItemBackground"` to the root view of your list item layout

## 💡 How to show my list of data in a grid rather that list?
`RecyclerView` supports drawing different configurations by using `LayoutManagers`.

Take a look at `GridLayoutManager` to draw items in a grid