# 🖥 Lab 2 Hints: Introducing Kotlin for Android

## 💡 Converting `settings.gradle` to `settings.gradle.kts`
After you convert the file extension, you'll need to update the invocation of the `include` function.

In Groovy, there is some syntactic sugar that allows calling a function with a single paramter without using any parentheses.
So, when we see `include ':app'` in the Groovy version, this is actually invoking the `include` function with the parameter `:app`.

When converting to Kotlin then, we need to update this invocation to use the parentheses `include(":app")`

## 💡 Converting `build.gradle` to `build.gradle.kts`
In the generated `build.gradle` file, there is an extension defined to specify the Kotlin version
`ext.kotlin_version = "1.5.10"`

This extension is then used in both `build.gradle` and `app/build.gradle`

When converting to `.kts` this extension pattern doesn't work quite the same way.  This leaves us with 2 options:
1. Update the extension to work in the .kts environment
2. In our case, we can simply remove it and update the two references accordingly
    1. In `build.gradle.kts` we can reference the Kotlin version directly as `"1.5.10"`
    2. In `app/build.gradle.kts` we can remove the explicit declaration of the Kotlin StdLib which is no longer required

## 💡 String literals in .kts files
In Groovy-based `.gradle` files, we cause use single, or double, quotes for String literals

However, in Kotlin-based buildscript files, we must use double quotes.  So when converting from `.gradle` to `.gradle.kts` it's often necessary to first update any strings to use double quotes

## 💡 Converting Java files to Kotlin files
This can be done several ways:
1. By right-clicking a Java file in the `Project` tool window and selecting the conversion option
2. Navigating to `Menu` -> `Code` -> `Convert Java File to Kotlin File`
3. Using the hotkey assigned to the `Convert Java File to Kotlin File` action
4. Use the hotkey for the `Action Lookup` action, start typing `Convert Java File...` and selecting the desired action

## 💡 Using Kotlin Scratch Files
Scratch files can be a great way to quickly prototype some code without building/running your whole project.

After you implement a function in the scratch file, don't forget to invoke the function.  If you don't explicitly invoke the function, you will not see the desired output.