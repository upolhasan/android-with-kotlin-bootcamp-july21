# 🖥 Lab 23: Generating a Signed Release Build
Let's prepare our app for release

## Objectives
1. Setup `dev` and `prod` flavors of your application
1. Setup the `release` build type
2. Ensure that minification and obfuscation are enabled for `release` builds
3. Generate an upload `key` and `keystore`
   - https://developer.android.com/studio/publish/app-signing#generate-key
4. Generate a signing configuration to automatically sign `release` builds
   - https://developer.android.com/studio/publish/app-signing#sign-auto
5. Remove signing information from your build files
   - https://developer.android.com/studio/publish/app-signing#secure-shared-keystore
6. Uniquely configure `versionName` and `versionCode` based on build type
   - use Android Gradle Plugins `onVariants()` apis
