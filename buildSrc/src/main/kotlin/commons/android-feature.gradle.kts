plugins {
    id("android-convention")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
}

private val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

val androidLibs = listOf(
    libs.android.appCompat,
    libs.android.coroutines,
    libs.android.koin
)

dependencies {
    androidLibs.forEach { lib -> implementation(lib) }
}
