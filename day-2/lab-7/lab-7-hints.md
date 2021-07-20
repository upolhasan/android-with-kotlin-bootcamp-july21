# 🖥 Lab 7 Hints: Customizing the Look and Feel of Our Application

## 💡 Helpful Resources
- [Overview of App Resources](https://developer.android.com/guide/topics/resources/providing-resources)
- [Configuration-Based Resource Naming](https://developer.android.com/guide/topics/resources/providing-resources#QualifierRules)
- [Themes vs Styles](https://developer.android.com/guide/topics/ui/look-and-feel/themes#versus)
- [String Resources Docs](https://developer.android.com/guide/topics/resources/string-resource)
- [Color Resources Docs](https://developer.android.com/guide/topics/resources/more-resources#Color)
- [Dimension Resources Docs](https://developer.android.com/guide/topics/resources/more-resources#Dimension)
- [Style Resources Docs](https://developer.android.com/guide/topics/resources/style-resource)
- [Boolean Resources Docs](https://developer.android.com/guide/topics/resources/more-resources#Bool)
- [Drawable Resources Docs](https://developer.android.com/guide/topics/resources/drawable-resource)
- [MaterialComponents Theming Getting Started Guide](https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md)
- [Material.io Color System Guide](https://material.io/design/color/the-color-system.html#color-theme-creation)

## 💡 What other Themes are available?
There are a lot of possible Themes to choose to apply to your application.  The two flavors you're mostly likely to run across include:
1. AppCompat
2. MaterialComponents

When starting a new Android app, it's best these days to use the MaterialCompoents library, and by extension, to use `Theme.MaterialComponents` as a starting point for your own custom app theme.

Check out the `Getting started with Material Components for Android` [README](https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md) for more info.

## 💡 How to pick colors for my app theme?
Check out the [Material.io Color tool](https://material.io/resources/color/#!/?view.left=0&view.right=0)

## 💡 How are my Theme colors applied to my app?
The colors applied to our application theme make up the default set of colors that our Views will pull from for their default styling.

This is especially true when using Views from the Material Components library which do a great job with default theming.

The Material.io site has some [great resources](https://material.io/develop/android/theming/color) for better understanding how individual Theme colors are used.
A few of the most common colors include
1. `colorPrimary`: _The color displayed most frequently across your app’s screens and components_
2. `colorPrimaryVariant`: _A tonal variation of the primary color. For light-mode themes, this is usually a slightly darker variant of `colorPrimary`_
3. `colorOnPrimary`: _A color that passes accessibility guidelines for text/iconography when drawn on top of the primary color._   
4. `colorSecondary`: _The secondary branding color for the app, usually an accented complement to the primary branding color._

## 💡 How to get the backgroundColor property from the Theme?
If you want to use the Theme's current `backgroundColor` property for you own `View`, say for example the background of a `Fragment` container, you can reference the property as `android:background="?backgroundColor"`