# 🖥 Lab 22: Building an Android Test Suite
Let's build a simple test suite for our app

## Objectives
1. Write unit tests for `MyNotesViewModel`
    1. Write tests to verify `ViewState` expectations
    2. Use `@Before` annotation method to simplify test setup
    3. Use `Mockito` to mock repository behavior
2. Write instrumentation tests for `MainActivity`
    1. Write a basic test to verify Android framework api
    2. Write an Espresso test to verify the AppBar title is correct in `MainActivity`
3. Use Gradle Wrapper to run unit tests from the command line
4. Use Gradle Wrapper to run instrumentation tests from the command line 