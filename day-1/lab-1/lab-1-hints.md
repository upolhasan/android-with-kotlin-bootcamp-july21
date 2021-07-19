# 🖥 Lab 1 Hints: Deploying Your First Android App

## 💡 Installing the JDK
AdoptOpenJDK is a great option
  - [Download Site](https://adoptopenjdk.net/)
  - [via Brew](https://github.com/AdoptOpenJDK/homebrew-openjdk)

For Android Studio projects created with versions of Android Studio 4.2+ you'll need to choose a version of JDK 11+ to be compatible with the Android Gradle Plugin.

To ensure compatability/stability, use a version between JDK 11-15.

## 💡 Exporting JAVA_HOME
https://docs.opsgenie.com/docs/setting-java_home

### Exporting JAVA_HOME on Unix Systems
- Locate your shell startup script
    - likely something similar to `.bashrc`, `.bash_profile`, `.zshrc`
- Set the `JAVA_HOME` variable as follows
```
# JDK Setup
export JAVA_HOME=<JDK Path>/Contents/Home
export PATH=$JAVA_HOME:$PATH
```

** If installing AdoptOpenJDK on a Mac via Brew, your JDK Path likely looks something like
`/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk`

### Exporting JAVA_HOME on Windows 10
- Open `Command Prompt` as Administrator
- Set the `JAVA_HOME` variable as follows
```
setx -m JAVA_HOME "C:\Progra~1\Java\<JDK Version>"
```

## 💡 Exporting ANDROID_HOME
Setting `ANDROID_HOME` will be very similar to setting `JAVA_HOME`

On Mac, the path to the SDK likely looks something like `/Users/<your user>/Library/Android/sdk`

## 💡 Invoking the Gradle Wrapper

### On Mac/Linux
- From the terminal, navigate to the root directory of your Android Studio project
- run `./gradlew <task name>`

To test this, you can run the simplest Gradle task; the `help` task `./gradlew help`

### On Windows
- From the terminal, navigate to the root directory of your Android Studio project
- run `gradle.bat <task name>`

To test this, you can run the simplest Gradle task; the `help` task `gradle.bat help`