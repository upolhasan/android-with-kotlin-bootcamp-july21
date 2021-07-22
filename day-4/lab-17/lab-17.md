# 🖥 Lab 17: Downloading and Parsing JSON Data Using Volley
Let's use Volley to download, parse, and display JSON data to populate our `StudyGuideFragment`

## Objectives
1. Add Volley dependency `implementation("com.android.volley:volley:1.2.0")`
2. Add the `android.permission.INTERNET` permission
3. Define url to your json content representing 'topic' items
    1. Can use `https://raw.githubusercontent.com/goobar-dev/workshop-sample-data/main/android-study-guide-data.json`
4. Configure your `JsonArrayRequest` instance
5. Create a new Volley request queue and submit your request
6. Add Moshi dependency `implementation("com.squareup.moshi:moshi:1.12.0")`
7. Add Moshi-Kotlin-Codegen dependency `kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")`
8. Create a `Topic` data class and annotate with `@JsonClass(generateAdapter = true)`
9. Write a `parseResponse()` method to take in the `JsonArray` response from Volley and return a `List<Topic>` using Moshi
10. Display the topic list as a list of items in `StudyGuideFragment`

## Challenges
1. Apply an MVVM architecture to `StudyGuideFragment`
2. Display a progress indicator while Volley is loading data
3. Add a `TopicDetailFragment` and show it when clicking a `Topic`
