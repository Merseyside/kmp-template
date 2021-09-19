
plugins {
    id("android-convention")
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform")
    kotlin("kapt")
    id("kotlinx-serialization")
}

kotlin {
    android()
}

val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

val androidLibs = listOf(
    libs.android.appCompat,
    libs.android.coroutines,
    libs.serialization
)

val androidMerseyLibs = listOf(
    libs.android.merseyLib.utils
)

val androidMerseyModules = listOf(
    Modules.Android.MerseyLibs.utils
)

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.koin,
    libs.multiplatform.moko.mvvm,
    libs.multiplatform.moko.resources
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.archy,
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    libs.multiplatform.merseyLib.archyCore,
    libs.multiplatform.merseyLib.utilsCore
)

dependencies {
    commonMainImplementation(project(Modules.MultiPlatform.domain))

    mppLibs.forEach { lib -> commonMainImplementation(lib) }
    androidLibs.forEach { lib -> androidMainImplementation(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib) }
    }

    if (isLocalAndroidDependencies()) {
        androidMerseyModules.forEach { module -> androidMainImplementation(project(module)) }
    } else {
        androidMerseyLibs.forEach { lib -> androidMainImplementation(lib) }
    }
}