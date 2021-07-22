# 🖥 Lab 12 Hints: Saving User Preferences Using SharedPreferences

## 💡 Helpful Resources
- [Get Starting with Settings UI](https://developer.android.com/guide/topics/ui/settings)
- [Save key/value Data with SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences)
- [SharedPreferences API Docs](https://developer.android.com/reference/android/content/SharedPreferences)
- [String Array Resources](https://developer.android.com/guide/topics/resources/string-resource#StringArray)

## 💡 How can we programmatically set light/dark mode?
We can call `AppCompatDelegate.setDefaultNightMode()` from an `Activity` or `Application`.
We can then pass one of the following flags to control the behavior
1. `AppCompatDelegate.MODE_NIGHT_NO`
2. `AppCompatDelegate.MODE_NIGHT_YES`
3. `AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM`

## 💡 Why is my preference value missing when I try to access it from my application class?
The build-in `SharedPreferences` UI components save settings to the applications default `SharedPreferences`.

If you are trying to access a custom `SharedPreference` file, your preference UI values will be missing.

To access preferences controlled by a `ListPreference` for example, ensure you call `PreferenceManager.getDefaultSharedPreferences(context)` to access the default preferences file.

## 💡 How do I create a string-array resource?
```xml
<string-array name="preference_theme_items">
    <item>Light</item>
    <item>Dark</item>
    <item>System</item>
</string-array>
```

You can also pass string resources as the item values

## 💡 How to retrieve a value from SharedPreferences?
```kotlin
val prefStringVale = PreferenceManager.getDefaultSharedPreferences(context).getString("pref key", "default value")
```