# 🖥 Lab 6: Building a Complex User Interface

## 💡 Helpful Resources
- [BottomNavigationView Documentation](https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView)
- [Set Up the App Bar Documentation](https://developer.android.com/training/appbar/setting-up)
- [Toolbar.inflateMenu()](https://developer.android.com/reference/android/widget/Toolbar#inflateMenu(int))
- [Populating a Dropdown Spinner](https://developer.android.com/guide/topics/ui/controls/spinner)
- [TextInputLayout Documentation](https://developer.android.com/reference/com/google/android/material/textfield/TextInputLayout)
- [MaterialDesign Text Fields Guidance](https://material.io/components/text-fields/android)

## 💡 Setting Toolbar title
The title of a `Toolbar` can be set programmatically or in xml.

### Via XML
`app:title="Android Study Guide"`

### Via Code
```
val toolbar: Toolbar = findViewById(R.id.toolbar)
toolbar.title = "Your Title"
```

## 💡 View is not constrained properly
Do you have a view that doesn't seem to respect the constraints you've applied to it?

Is your view filling the screen in some axis instead of restricting itself to some barrie/alignment?

This can happen if you've applied constraints, but told the view to `match_parent` along some axis. Double check that your height/width is using `0dp` size along whichever axis it should be constrained.

## 💡 Z-ordering
Views in a layout have an implicit z-ordering.  Items defined _after_ other items will draw on top of preceding items.
However, the z-ordering also takes into account any elevation applied to an element.

Take the following scenario for example:
```
<ViewGroup>
  <Material.Button>
  <FrameLayout>
</ViewGroup>
```

Which element will be drawn on top of the other?
We might thing that the FrameLayout will be on top because it's defined second.

However, because the Button View defined in the Material design component library have an elevation applied to them, they actually get drawn over the FrameLayout.

This may not be what you want/expect.  To fix this, you could show/hide the Buttons as needed, or you could apply a greater elevation to the FrameLayout so its content draws above the Button.

## 💡 Theming TextInputLayout
`TextInputLayout` comes in 2 styles:
1. `Filled`
2. `Outlined`

To change the style to `Outline` apply the following to your XML `style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox"`