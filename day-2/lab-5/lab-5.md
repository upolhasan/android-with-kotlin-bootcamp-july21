# 🖥 Lab 5: Working with Activities and Fragments
In this lab, we will setup a basic navigation infrastructure for our new Study app

## Objectives
0. Create a new Android Studio project named `Android Study Guide`
1. Ensure you have an empty Kotlin Activity named `MainActivity`
    1. This should be set as the app's launcher activity in `AndroidManifest.xml`
2. Create a second Kotlin Activity named `TwitterActivity`
    1. This will be used later this week to integrate with Twitter's PWA
3. Create 4 Fragments that will become the core screens in our app
    1. `CreateNoteFragment`
    2. `NoteDetailFragment`
    3. `MyNotesFragment`
    4. `StudyGuideFragment`
4. For each `Activity` & `Fragment` add a `TextView` to the layout that uniquely identifies that screen
5. Add a `Button` to `MainActivity` that shows `TwitterActivity` when clicked
6. Add 4 `Buttons` to `MainActivity` that show each of the new `Fragments` when clicked

## Challenges
1. Add log messages to key lifecycle events in an `Activity` and `Fragment` to observe lifecycle changes as you interact with your app
2. Temporarily change your app's launcher `Activity` to `TwitterActivity` and observe the impact on your app