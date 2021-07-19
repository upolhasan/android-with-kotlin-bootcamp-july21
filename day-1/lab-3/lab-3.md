# 🖥 Lab 3: Exploring Kotlin Fundamentals

## Objectives
0. Open the lab-3 project in Android Studio
1. Open `Functions.kt` and update/implement the functions there to make the tests in `FunctionTests.kt` pass
2. Open `Loggers.kt` and implement the interfaces, classes, and functions required to make the tests in `OOPTests.kt` pass
    1. You'll need to implement a `Logger` interface
    2. You'll need a `BasicLogger` Object class that implements `Logger`
    3. You'll need a `FancyLogger` class that implements `Logger`
    4. You'll need an extension function on the `BasicLogger` class to log multiple messages at the same time
3. Open `SupportedLanguages.kt` and update/implement the code to make the tests in `SealedClassTests.kt` pass
    1. You'll need to add a `InvalidNameException` and `EmptyNameException` to the `SupportedAndroidLanguageException` sealed class
4. Open `CollectionsProcessing.kt` and update/implement the function to make the tests in `CollectionsTests.kt` pass


## Challenges
1. Create an `ExtraFancyLogger` class that extends `FancyLogger`.  It should specify both a `logTag` and a `separator` and override the `log()` implementation to use both properties when logging the message.
2. Create an extension function on `BasicLogger` that takes in a `List<String>` and prints each message using `BasicLogger.log()`