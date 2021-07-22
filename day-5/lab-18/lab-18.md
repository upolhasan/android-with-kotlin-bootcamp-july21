# 🖥 Lab 18: Implementing a Service for Background Upload
Let's implement a service to upload a `Note` to a public `GitHub` repo

## Objectives
1. Add an "Upload" button to `NoteDetailFragment`
    1. When clicked, this button will eventually start our Service
2. Create a `NoteUploadService` that extends `Service` and register it in `AndroidManfiest.xml`
3. Create a companion object in `NoteUploadService`
4. Create a `getNoteUploadIntent(context: Context, note: Note): Intent` method
    1. This should return an `Intent` for starting `NoteUploadService`
    2. This should add an extra for Base64 encoded "content" coming from the passed `Note`
    3. This should add an extra for the filename to store the note as
5. Using `getNoteUploadIntent()`, start the `Service` from `NoteDetailFragment` when the upload button is clicked
6. In `NoteUploadService.onStartCommand()` parse the filename, and content `String`s from the `Intent`
7. Build a `JsonObjectRequest` with Volley to create a new file, in GitHub, containing the contents of your `Note`
    1. Should use a `PUT`
    2. Url should be a url to some public repository that you own and include the desired filename as the final PATH param   
    3. The `jsonRequest` body must include `"message"` and `"content"` values
    4. Must include an `Authorization` header to authenticate the request
8. Move request processing off the main thread
    1. Setup a `HandlerThread` in `NoteUploadService.onCreate()` to manage requests off the main `Thread`
    2. Save a `Looper` reference
    3. Create a `ServiceHandler` class to handle `Looper` `Messages` and upload file data
    4. Create an instance of `ServiceHandler` within your `HandlerThread` on onCreate()
    5. In `onStartCommand()` process incoming `Messages` and send them to your `ServiceHandler` to trigger upload

## Challenges
1. Add some form of user feedback to indicate that the upload was successful
2. Add a unique id to each filename so that you can upload new copies of a `Note`
3. Use the GitHub api to acquire the SHA for an existing file so you can upload new versions of a file using the same filename
4. Convert service to a Foreground `Service` and display a notification while upload is in process