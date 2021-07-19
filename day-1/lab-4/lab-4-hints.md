# 🖥 Lab 4 Hints: Building a Game Counter App

## 💡 Referencing Views from code

After we have added our views to our XML layout, we often want to work with those views from Kotlin or Java code. 
To do that, we need to get a reference to those views.

To do that from an `Activity` we can use the `findViewById()` method.

For example, let's imagine we need to access a TextView.

Make sure your XML `TextView` has an `android:id=` attribute with a valid id; say `android:id=@+id/scoreText`
Then, from your Kotlin Activity call `val myView: TextView = findViewById(R.id.scoreText)`

From there, you can interact with your `TextView` however you like.

## 💡 Setting the display text in your TextView

You can do this in 2 ways:
1. from XML
2. from Code

### From XML
Use `android:text="your text here"`

### From Code
Use `yourTextView.text="your text here"

## 💡 Is your Toast not showing?
Make sure you call `.show()` after you've configured your `Toast`

It should look something like:

`Toast.makeText(this, "your message", Toast.LENGTH_SHORT).show()`