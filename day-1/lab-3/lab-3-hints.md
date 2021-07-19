# 🖥 Lab 3 Hints: Exploring Kotlin Fundamentals

## 💡 Filtering values from a Collection
The Kotlin Standard Library has several helpful functions for filtering values from a collection:
1. `filter{}` The generic filter function takes a lambda allowing you to specify your own filtering criteria
2. `filterNotNull()` Will filter out any null values

## 💡 Extending a class
Class in Kotlin are closed for extension by default.  To extend a class you must do 1 of 2 things
1. Make the base class abstract
2. Mark the base class as open for extension by adding the `open` modifier to the class declaration

## 💡 Extending a method
Like classes, methods in Kotlin are closed for extension be default.

To mark a method as being open for extension in child classes, add the `open` modifier to the method declaration
