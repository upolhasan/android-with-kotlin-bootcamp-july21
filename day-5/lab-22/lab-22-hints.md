# 🖥 Lab 22 Hints: Building an Android Test Suite

## 💡 Helpful Resources
- [Build Effective Android Unit Tests](https://developer.android.com/training/testing/unit-testing)
- [Build Local Unit Tests](https://developer.android.com/training/testing/unit-testing/local-unit-tests)
- [Build Instrumentation Tests](https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests)
- [Mock Dependencies with Mockito](https://github.com/mockito/mockito)

## 💡 What dependencies do I need to setup Android instrumentation tests?
```kotlin
androidTestImplementation('androidx.test:runner:1.1.0')
androidTestImplementation('androidx.test:rules:1.1.0')

// optional - only if you want Espresso tests
androidTestImplementation('androidx.test.espresso:espresso-core:3.1.0')
```

## 💡 What dependencies do I need to setup unit tests?
```kotlin
testImplementation("junit:junit:4.12")

// optional - only if you want to mock types with Mockito
testImplementation("org.mockito:mockito-core:1.10.19")
```

## 💡 Do I need to do anything to configure my test setup?
To simplify test setup, set your `testInstrumentationRunner` to use the androidx `AndroidJUnitRunner` class

```kotlin
android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
```

## 💡 How do I setup a basic instrumentation test?
Create a new test class, and add test methods that are annotated with `@Test`.

```kotlin
@Test
fun verifySomeBehavior() {
    // test logic
}
```