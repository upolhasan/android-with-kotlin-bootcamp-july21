# 🖥 Lab 12: Saving User Preferences Using SharedPreferences
Let's add a setting to our app to control whether our app uses light mode, dark mode, or matches the system theme.

## Objectives
1. Create a `AndroidStudyGuideApplication` class that extends `Application`
    1. Set this new application as your app's application class in `AndroidManifest.xml` by adding `android:name=".AndroidStudyGuideApplication"`
2. Within `AndroidStudyGuideApplication.onCreate()` programmatically set your app to use Night Mode
    1. Call `AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)`
    2. Redeploy your app to observe the impact of this change.  Your app should now stay in Night mode regardless of the system UI setting
3. Create a new `preferences` package within your app
4. Create a preferences screen resource for accessing app settings supported by `SharedPreferences`   
    1. Add the `androidx.preference:preference-ktx:1.1.1` dependency in your `app/build.gradle` file
    2. Create a new file `res/xml/preferences.xml` to define a preference screen
    3. Within `preferences.xml` add a new `ListPreference` to allow selection of theme setting options
    4. Create a `res/values/arrays/xml` file and create a `string-array` resource to for your `ListPreference` options
    5.  Return to `preferences.xml` and use your `string-array` to set `app:entryValues`, `app:defaultValue`, and `app:entries`
5. Create a `Fragment` to display the `preferences.xml` resource
    1. Create a `PreferencesFragment` that extends `PreferenceFragmentCompat`
    2. Within `PreferenceFragment.onCreatePreferences()` call `setPreferencesFromResource(R.xml.preferences, rootKey)` and pass in your preferences resource id
6. Make `PreferencesFragment` accessible from `MainActivity`
    1. Add a "preferences" menu item to `main_toolbar.xml` to display this new `Fragment` when selected
    2. Add a `PreferencesFragment` destination within `main_navigation.xml`
    3. Navigate to `PreferencesFragment` when the preferences menu item is clicked
7. Within `AndroidStudyGuideApplication.onCreate()` query the current theme preference and programmatically set the theme accordingly

## Challenges
1. Add a `OnSharedPreferenceChangeListener` to listen for changes to preference values and immediately update your app's theme setting
2. Add a `PreferenceCategory` to your preference screen improve the look of your UI