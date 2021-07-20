# 🖥 Lab 9 Hints: Building a Navigation Graph

## 💡 Helpful Resources
- [Getting Started with Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Updating Bottom Navigation with Navigation Component](https://developer.android.com/guide/navigation/navigation-ui?hl=tr#bottom_navigation)
- [Animating Between Destinations](https://developer.android.com/guide/navigation/navigation-animate-transitions)

## 💡 Which dependencies do I need to add?
While the documentation lists quite a few related dependencies, for this Lab you should only need these two dependencies for the Navigation Component
```groovy
dependencies {
  implementation "androidx.navigation:navigation-fragment-ktx:2.3.5"
  implementation "androidx.navigation:navigation-ui-ktx:2.3.5"
}
```

## 💡 How to build my Navigation graph?
A Navigation graph can edited in 2 ways
1. Using the interactive UI designer
2. From XML

Anything you change in the UI designer will be reflected in the XML.

## 💡 How to add a destination to my Navigation graph?
You can do this 2 ways
1. Open the UI designer, and click the `Add Destination` button in the toolbar. Look for the green + icon.
2. In the XML, add a `<Fragment>` tag and specify the `android:id` and `android:name` attributes

## 💡 How to add a Navigation Action from one destination to another?
This can be done 2 ways
1. In the UI designer, drag from one Destination to the other.  This should create a line connecting the two Destinations.  This line represents the Action and can be selected/configured.
2. In the XML, find the `<Fragment>` tag for the destination you're starting from.  Within that tag, add a `<action>` specifying the `android:id` and `app:destination` attributes

## 💡 How to parse an argument from NavController.addOnDestinationChangedListener() ?
Do you need to check whether a Navigation destination includes a specific argument when navigated to?

Let's imagine we're checking the value of `"ShowAppBar"`.  Within our `OnDestinationChangedListener` we could check for the argument value like this:
```kotlin
val showAppBar = arguments?.getBoolean("ShowAppBar", false) == true
```