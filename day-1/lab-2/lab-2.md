# 🖥 Lab 2: Introducing Kotlin for Android

## Objectives
1. Create a new Kotlin file named `hello-world.kt` within your app's primary src directory
2. Write a Kotlin function named `helloWorld()` that prints `"Hello World!"` to the console when invoked
3. Call this new function from your `MainActivity.onCreate()` method
4. Deploy your app to a device/emulator and observe the `"Hello World!"` output in the `Run` tool window
5. Within `hello-world.kt`, create `main()` function that invokes `helloWorld()`
6. Run the `main()` function and observe the output in the `Run` tool window
7. Update your `helloWorld()` function to use Android's `Log.d(tag, message)` method rather than Kotlin's `println()`
    1. For the `tag` parameter, you can use any String you wish.  A common convention is to use the name of the class that is calling the method
    2. For the `msg` parameter, pass `"Hello World!"`
8. Deploy your app again, and this time observe the output from the `Logcat` tool window
    1. Use the search box in the `Logcat` window to search for the tag you used when invoking `Log.d()`
9. Within your primary src directory, create a new Java class named `SampleClass`
    1. Right-click on the class name declaration, and click the `Generate` option
    2. Generate implementations for `toString()`, `equals()`, and `hashCode()`
10. In the `Project` tool window, right-click the `SampleClass.java` file name and select `Convert Java File to Kotlin File`
    1. Once the conversion is complete, review the changes
    2. You can then delete the file if you wish
11. Convert `settings.gradle` to `settings.gradle.kts`
12. Convert `build.gradle` to `build.gradle.kts`    

## Challenges
1. Modify your `helloWorld()` function to take a custom greeting as a parameter
2. Modify your `helloWorld()` function to use a String Template to format the output message   
3. Create a new Kotlin Scratch File, implement `helloWorld()`, and invoke the function to observe the interactive output   
4. Convert `app/build.gradle` to `app/build.gradle.kts`