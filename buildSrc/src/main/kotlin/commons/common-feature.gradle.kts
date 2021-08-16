import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform")
    kotlin("kapt")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kotlin {
    android()
}

val androidLibs = listOf(
    Deps.Android.appCompat,
    Deps.Android.coroutines,
    Deps.Android.serialization
)

val androidMerseyLibs = listOf(
    Deps.Android.MerseyLibs.utils
)

val androidMerseyModules = listOf(
    Modules.Android.MerseyLibs.utils
)

val mppLibs = listOf(
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.mokoMvvm,
    Deps.MultiPlatform.mokoResources
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.archy,
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.archy,
    Deps.MultiPlatform.MerseyLibs.utils
)

dependencies {
    commonMainImplementation(Deps.MultiPlatform.coroutines)
    commonMainImplementation(project(Modules.MultiPlatform.domain.name))

    mppLibs.forEach { lib -> commonMainImplementation(lib.common) }
    androidLibs.forEach { lib -> androidMainImplementation(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module.name)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib.common) }
    }

    if (isLocalAndroidDependencies()) {
        androidMerseyModules.forEach { module -> androidMainImplementation(project(module)) }
    } else {
        androidMerseyLibs.forEach { lib -> androidMainImplementation(lib) }
    }
}