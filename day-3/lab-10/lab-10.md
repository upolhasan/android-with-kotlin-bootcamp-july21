# 🖥 Lab 10: Using Explicit and Implicit Intents

## Objectives
1. Review navigation to `TwitterActivity` via explicit intent
2. When `TwitterActivity` opens, launch an Implicit `Intent` to send a Tweet
3. Add a `Share` item to `main_toolbar.xml`
4. When `Share` is selected, use an Implicit `Intent` to send a message
5. Add support for selecting and displaying an image in `CreateNoteFragment`   
    1. Within `CreateNoteFragment`, add an `ImageView` with a default svg icon
    2. When the `ImageView` is clicked, create an Implicit `Intent` to select an image`
    3. Start the image selection `Intent` with `startActivityForResult(imageSelectionIntent)`   
    4. Override `CreateNoteFragment.onActivityResult()` to respond to the selected image URI
    5. Check that the `requestCode` matches the request used in `startActivityForResult()`
    6. Check that the `resultCode == Activity.RESULT_OK`
    7. If both codes look correct, access the selected image URI by calling `data.data`
    8. Use that URI to set the image into your `ImageView`

## Challenges
1. Change the `scaleType` on your `ImageView` so that the aspect ratio is not changed when the image URI is set
2. Display feedback to the user if the "select photo" Intent returns a result other than `Activity.RESULT_OK`