import dependencies.Deps
import extensions.isLocalDependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-kapt")
    id("dev.icerock.mobile.multiplatform")
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

val androidLibs = listOf(
    Deps.Android.appCompat,
    Deps.Android.coroutines,
    Deps.Android.serialization,
    Deps.Android.koinViewModels
)

val mppLibs = listOf(
    Deps.MultiPlatform.kotlinStdLib,
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.coroutines,
    Deps.MultiPlatform.mokoMvvm,
    Deps.MultiPlatform.mokoResources,
    Deps.MultiPlatform.mokoUnits
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.kmpCleanArch,
    Modules.MultiPlatform.MerseyLibs.kmpUtils
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.kmpCleanArch,
    Deps.MultiPlatform.MerseyLibs.kmpUtils
)

dependencies {
    mppLibs.forEach { lib -> mppLibrary(lib) }
    androidLibs.forEach { lib -> implementation(lib.name) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> mppModule(module) }
    } else {
        merseyLibs.forEach { lib -> mppLibrary(lib) }
    }
}