# 🖥 Lab 7: Customizing the Look and Feel of Our Application
Let’s make our app look a little better by leveraging the Android resource system.

## Objectives
1. Define new Color resources to customize your app theme
2. Update the primary, and secondary colors of your app's theme using the newly created Color resources    
    1. Deploy your app to observe the updated theme
3. Change your device to Dark Mode and redeploy your app
    1. Notice that it likely doesn't look how you might expect
4. Update the `values-night` version of your app's theme with your custom colors and to remove the default `Toolbar`
5. Add the following values to both the Light and Dark Themes
    1. `colorSurface`
    2. `backgroundColor`
6. Change the `android:background` attribute of each `Fragment` to pull from the Theme's `backgroundColor` property
7. Add VectorDrawable icons to your `BottomNavigationView` menu
    1. One icon for `MyNotesFragment`
    2. One icon for `StudyGuideFragment`
8. Create a new VectorDrawable icon for thee `FloatingActionButton` in `MyNotesFragment`
9. Import a custom png icon for the Twitter menu item in your `Toolbar`
    1. Can find icons here https://www.flaticon.com/
10. Replace all menu item strings with String resource values
11. Apply the following text Styles to the `TextViews` in `NoteDetailFragment`
    1. `TextAppearance.MaterialComponents.Headline3`
    2. `TextAppearance.MaterialComponents.Headline4`
    3. `TextAppearance.MaterialComponents.Body1`
12. Define the following Dimension resources and apply them, where applicable, in your `Fragments`    
    1. `spacing_1x=8dp`
    2. `spacing_2x=16dp`
    3. `spacing_3x=24dp`

## Challenges
1. Create a custom app icon
2. Provide an alternative horizontal layout for `CreateNoteFragment` and/or `NoteDetailsFragment`
3. Provide localized Strings for another locale, change your device locale, and observe the localized Strings displayed
4. Customize the typography of your app by setting custom text styles in your theme.
