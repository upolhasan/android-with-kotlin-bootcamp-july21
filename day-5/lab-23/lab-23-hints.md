# 🖥 Lab 23 Hints: Generating a Signed Release Build

## 💡 Helpful Resources
- [Sign Your App](https://developer.android.com/studio/publish/app-signing)
- [onVariants() Example](https://android-developers.googleblog.com/2020/12/announcing-android-gradle-plugin.html)

## 💡 How to store signing config info outside of repo
First, in your root project directory, create a `keystore.properties` file
```groovy
storePassword=<your store password>
keyPassword=<your key password>
keyAlias=<your key alias>
storeFile=<path to your keystore>
```

Then, load the contents of that file in your `app/build.gradle` file and use the properties when setting up your signing config
```groovy
// Create a variable called keystorePropertiesFile, and initialize it to your
// keystore.properties file, in the rootProject folder.
def keystorePropertiesFile = rootProject.file("keystore.properties")

// Initialize a new Properties() object called keystoreProperties.
def keystoreProperties = new Properties()

// Load your keystore.properties file into the keystoreProperties object.
keystoreProperties.load(new FileInputStream(keystorePropertiesFile))

android {
    ...

    signingConfigs {
        release {
            keyAlias keystoreProperties['keyAlias']
            keyPassword keystoreProperties['keyPassword']
            storeFile file(keystoreProperties['storeFile'])
            storePassword keystoreProperties['storePassword']
        }
    }
}
```

## 💡 How to use beforeVariants apis of Android Gradle Plugin to customize versionName and versionCode based on build type?
```kotlin
androidComponents {
  val debug = selector().withBuildType("debug")
  onVariants(debug) {
    it.outputs.forEach { 
      it.versionCode.set(1) 
      it.versionName.set("1.0")
    }
  }
  
  val major = 1
  val minor = 0
  val subminor = 0
  val releaseVersion = major * 1000 + minor * 100 + subminor * 10

  val release = selector().withBuildType("release")
  onVariants(debug) {
    it.outputs.forEach {
      it.versionCode.set(releaseVersion)
      it.versionName.set("$major.$minor.$subminor")
    }
  }
}
```