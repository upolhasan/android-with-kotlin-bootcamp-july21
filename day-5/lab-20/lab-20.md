# 🖥 Lab 20: Integrating a Web App into Your Application

## Objectives
1. Review existing use of `Intent` to launch Twitter
   - Notice that this takes user to another app to carry out the action
2. Load Twitter's PWA using a `WebView`
    1. Add a `WebView` to `activity_twitter.xml`
    2. Enable Javascript on the `WebView`
    3. Call `WebView.loadUrl()` with `"https://mobile.twitter.com"`
3. Load Twitter's PWA directly into the "Composer"
    1. Replace the loading of `"https://mobile.twitter.com"` with `"https://mobile.twitter.com/intent/tweet?hashtags=$csvFormattedHashtags"`
4. Display a native `ProgressBar` when PWA is loading
    1. Create a `ProgressChromeClient` class that extends `WebChromeClient`
    2. Update the constructor to take a single `ProgressBar` property   
    3. Within `onProgressChanged()` show the `ProgressBar` any time the current progress is between 1-99
    4. Set an instance of `ProgressChromeClient` as the `webChromeClient` on the `WebView`
    5. Re-launch your `TwitterActivity` to observe your native `ProgressBar` being updated in response to loading of the PWA
5. Display yor own simple web app that bridges between Javascript and Kotlin
    1. Create a class `SimpleWebAppInterface` that takes an `Activity` as a constructor property
    2. Add two methods to the class `fun showToast(toast: String)` and `fun navigateBack()`
    3. Annotate these methods with `@JavascriptInterface`
    4. Copy over the `WebView.loadSimpleWebApp()` function from the hints
    5. Invoke `loadSimpleWebApp()` from `TwitterActivity.onCreate()`
    6. Re-launch your `TwitterActivity` to observe that actions taken from the Javascript are responded to Natively

## Challenges
1. Add additional styling/actions to the HTML defined in `loadSimpleWebApp()` and respond natively
2. Add a `FloatingActionButton` that is drawn over your custom HTML/Javascript and that launches the Twitter PWA when clicked
    1. This demonstrates the mixing of native controls with web content for a hybrid approach