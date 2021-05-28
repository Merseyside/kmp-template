# Mobile Kotlin multiplatform project template
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) ![kotlin-version](https://img.shields.io/badge/kotlin-1.5.0-orange)

A sample project that helps to start building a Mobile Kotlin Multiplatform application. It establishes an architecture optimized for building cross-platform mobile applications through separation of concerns between the UI and business logic.

## Table of Contents

- [Features](#features)
- [Modules](#modules)
- [Screenshots](#screenshots)
- [How to Run](#how-to-run)
- [Project setup](#project-setup)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Kotlin Multiplatform**'s motto is *Don't Repeat Yourself*. Share the business logic code written in Kotlin between Android and iOS apps. 100% native UI and performance (shared code compiles into native libraries);
- **Kotlin Gradle DSL** – Configure project with flexible Kotlin Gradle DSL;
- **Modular-bazed architecture** – Implement app features independently of each other. Inject dependencies into features at compile-time through the use of the `Factory` class;
- **Parallel build of modules** – Feature modules and the `domain` module don't depend on each other. This provides caching of build artifacts for each module and results in better compilation time;
- **Dependencies definition in buildSrc** - Simplify dependency management across modules;
- **Ready to use** - Template project includes all [moko libraries](https://moko.icerock.dev) and supports most common use cases:
  - ViewModels;
  - LiveData;
  - Resource management;
  - Runtime permissions access;
  - Media access;
  - UI lists management from shared code;
  - Network layer generation from OpenAPI.

## How to Run

Android - just open repository root directory in Android Studio and press `Run`.  
iOS - run `pod install` in directory `ios-app`. Then open `ios-app/ios-app.xcworkspace` and press `Run` on simulator/device.

## Project setup

### Setup your own ApplicationId

*Just like in other native apps*  
In `android-app/build.gradle.kts` change `org.example.app` in the following line:
```kotlin
applicationId = "org.example.app"
```
In Xcode project settings change `Bundle Identifier`.

### Setup your own project name

*Just like in other native apps*  
In `android-app/src/main/res/values/strings.xml` change value of `app_name`.  
In Xcode project settings change `Display name`.

### Setup your own app icon

*Just like in other native apps*  
Put your android icon to `android-app/src/main/res` and setup usage in `android-app/src/main/AndroidManifest.xml`.  
Put your iOS icon to `ios-app/src/Assets.xcassets/AppIcon.appiconset`.

### Create new feature module

Create a file `mpp-library/feature/myfeature/build.gradle.kts` with the following content:
```kotlin
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

dependencies {
    mppLibrary(Deps.Libs.MultiPlatform.kotlinStdLib)
}
```
Add module to `buildSrc/src/main/kotlin/Modules.kt`:
```kotlin
object Modules {
    object MultiPlatform {
        ...

        object Feature {
            ...

            val myfeature = MultiPlatformModule(
                name = ":mpp-library:feature:myfeature",
                exported = true
            )
        }
    }
}
```
Add module to `settings.gradle.kts`:
```kotlin
listOf(
    ...
    Modules.MultiPlatform.Feature.myfeature
).forEach { include(it.name) }
```
Add dependency to module from the `mpp-library` in `mpp-library/build.gradle.kts`:
```kotlin
val mppModules = listOf(
    ...
    Modules.MultiPlatform.Feature.myfeature
)
```

## Contributing

All development of template is performed in the `master` branch. Please send PRs with bug fixes to the `master` branch.

Please refer to the [contributing guide](CONTRIBUTING.md) for more details.

## License

    Copyright 2019 IceRock MAG Inc
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
