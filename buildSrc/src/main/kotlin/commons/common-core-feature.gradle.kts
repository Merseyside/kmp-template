import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform")
    kotlin("kapt")
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
    Deps.Android.koin,
    Deps.Android.MerseyLibs.utils
)

val mppLibs = listOf(
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.mokoResources
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.utils
)

dependencies {
    commonMainImplementation(Deps.MultiPlatform.coroutines)

    mppLibs.forEach { lib -> commonMainImplementation(lib.common) }
    androidLibs.forEach { lib -> androidMainImplementation(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module.name)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib.common) }
    }
}