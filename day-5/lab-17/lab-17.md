# 🖥 Lab 17: Downloading and Parsing JSON Data Using Volley
Let's use Volley to download, parse, and display JSON data to populate our `StudyGuideFragment`

## Objectives
1. Prep the project to make network requests using Volley
    1. Add Volley dependency `implementation("com.android.volley:volley:1.2.0")`
    2. Add the `android.permission.INTERNET` permission
2. In `StudyGuideFragment`, define a url constant pointing to your json content representing 'topic' items
    1. Can use `https://raw.githubusercontent.com/goobar-dev/workshop-sample-data/main/android-study-guide-data.json`
    2. Can define your own json response within any public GitHub repository
3. Construct your network request using Volley
    1. Create an instance of `JsonArrayRequest`
    2. Specify a `Request.Method.GET` request type
    3. Pass in the url to your public json content
    4. Pass `null` for the `jsonRequest` parameter
    5. Pass in instances of `Response.Listener` and `Response.ErrorListener`
4. Create a new Volley request queue and submit your request
5. Prepare the project to deserialize the Volley response
    1. Add Moshi dependency `implementation("com.squareup.moshi:moshi:1.12.0")`
    2. Add Moshi-Kotlin-Codegen dependency `kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")`
    3. Create a `Topic` data class and annotate with `@JsonClass(generateAdapter = true)`
6. Parse the Volley response into `List<Topic>`
    1. Write a `parseResponse()` method to take in the `JsonArray` response from Volley and return a `List<Topic>` using Moshi
    2. Call this method within your `Response.Listener`
7. Display the topic list as a list of items in `StudyGuideFragment`

## Challenges
1. Apply an MVVM architecture to `StudyGuideFragment`
2. Display a progress indicator while Volley is loading data
3. Add a `TopicDetailFragment` and show it when clicking a `Topic`
