# 🖥 Lab 13: Saving User Data Using DataStore
Let's save the last selected note category and default to that whenever the `CreateNoteFragment` is displayed

## Objectives
1. Integrate Proto DataStore into the project
    1. Apply the `com.google.protobuf` plugin to your project (see hints)
    2. Add the DataStore dependency to your project (see hints)
    3. Add `protobuf{}` config block `app/build.gradle` (see hints)
2. Define protobuf message to represent the default note category
    1. Create a protobuf file at `app/src/main/proto/DefaultCategory.proto`
    2. Within `DefaultCategory.proto`, define a `DefaultCategory` proto message with a single `string category = 1;` field
3. Prepare DataStore for interaction
    1. Create `DefaultCategorylSerializer` class that extends `Serializer<DefaultCategory>` (see hints)
    2. Create `defaultCategoryDataStore` extension property (see hints)
4. Update category spinner to respond to selection and to set default value
    1. Refactor `CategorySpinnerAdapter` to take a list of category `String`s in its constructor
    2. Create a top-level property to store a `List<String>` of category `String`s to pass to the adapter
    3. In `CreateNoteFragment.onCreateView()`, add a `OnItemSelectedListener` to your spinner
    4. Save the selected category to your `DataStore` each time the spinner is selected
    5. In `CreateNoteFragment.onViewCreated()` query `defaultCategoryDataStore` for the last used category and select that item in the current spinner