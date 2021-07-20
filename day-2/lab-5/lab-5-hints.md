# 🖥 Lab 5: Working with Activities and Fragments

## 💡 Helpful Resources
- [How to Create a Fragment?](https://developer.android.com/guide/fragments/create)
- [TextView Documentation](https://developer.android.com/reference/android/widget/TextView)
- [Button Documentation](https://developer.android.com/reference/android/widget/Button)
- [Material Design Button Guidance](https://material.io/components/buttons)

## 💡 Creating new Activities and Fragments
Android Studio can help us create a new `Activity` or `Fragment`.

However, the IDE often presents us with a handful of different templates such as `EmptyActivity`, `Fragment with ViewModel`, `List Activity`, etc

These can be kind of fun to play with when starting out, but more most situations you're going to want to choose `EmptyActivity` and `BlankFragment` so you can customize exactly how you want without having to remove stubbed out code.

## 💡 Logging to Logcat
The Android SDK provides a default set of logging functions:
- `Log.d()`
- `Log.e()`
- `Log.i()`
- etc

Adding these to your code can be a helpful way to observe the lifecycle of your application or to help track down bugs.

Output from these functions will go to `Logcat` which can be observed in the `Locat` tool window or using `adb`