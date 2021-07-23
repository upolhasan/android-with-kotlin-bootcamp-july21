# 🖥 Lab 19: Using WorkManager for Background Tasks
Let's use `WorkManager` to upload a `Note` to a public GitHub repo

## Objectives
1. Prepare the project to use `WorkManager`
    1. Add the `WorkManager` dependency to the project `implementation "androidx.work:work-runtime-ktx:2.5.0"`
2. Create a `Worker` to upload our `Note` to `GitHub`
    1. Create a `NoteUploadWorker` class that extends `Worker`
    2. Define a `uploadFileData(context: Context, filename:String, content:String)` method
    3. Within `uploadFileData()`, use Volley to upload a `Note` as a .txt file to `GitHub`
        1. see notes for URL formatting
    4. Override `doWork()` to use `uploadFileData()` to upload your `Note`
3. Submit work request to `WorkManager`
    1. Within `NoteDetailFragment.uploadNote()` construct a `WorkRequest` for `NoteUploadWorker`
    2. Submit the request to `WorkManager`