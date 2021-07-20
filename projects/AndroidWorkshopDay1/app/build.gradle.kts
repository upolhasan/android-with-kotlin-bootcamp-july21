plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  compileSdkVersion(30)
  buildToolsVersion("30.0.3")

  defaultConfig {
    applicationId = "dev.goobar.androidworkshopday1"
    minSdkVersion(23)
    targetSdkVersion(30)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {

  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

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

dependencies {

  implementation("androidx.core:core-ktx:1.6.0")
  implementation("androidx.appcompat:appcompat:1.3.0")
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.constraintlayout:constraintlayout:2.0.4")
  testImplementation("junit:junit:4.+")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}