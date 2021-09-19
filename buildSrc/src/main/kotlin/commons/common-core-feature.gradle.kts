
plugins {
    id("android-convention")
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform")
    kotlin("kapt")
}

private val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

val androidLibs = listOf(
    libs.android.appCompat,
    libs.android.coroutines,
    libs.serialization,
    libs.android.koin
)

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.koin,
    libs.multiplatform.moko.resources
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    libs.multiplatform.merseyLib.utilsCore
)

dependencies {
    mppLibs.forEach { lib -> commonMainImplementation(lib) }
    androidLibs.forEach { lib -> androidMainImplementation(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib) }
    }
}