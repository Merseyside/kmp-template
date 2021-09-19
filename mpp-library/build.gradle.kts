plugins {
    id(Plugins.versionCatalog)
    id(Plugins.androidLibrary)
    id(Plugins.kotlinMultiplatform)
    id(Plugins.mobileMultiplatform)
    id(Plugins.kotlinParcelize)
    id(Plugins.iosFramework)
    id(Plugins.sqldelight)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }
}

kotlin {
    android()
}

val androidLib = listOf(
    libs.android.sqldelight
)

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.koin,
    libs.multiplatform.settings,
    libs.multiplatform.moko.resources,
    libs.multiplatform.moko.mvvm,
    libs.multiplatform.sqldelight
)
val mppModules = listOf(
    projects.mppLibrary.domain,
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.archy
)

val merseyLibs = listOf(
    libs.android.merseyLib.archyAndroid
)

dependencies {
    androidLib.forEach { lib -> androidMainImplementation(lib) }

    commonMainImplementation(projects.mppLibrary.core)

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainApi(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainApi(lib) }
    }

    mppModules.forEach { module -> commonMainApi(project(module.name)) }
    mppLibs.forEach { lib -> commonMainApi(lib) }
}

framework {
    mppModules.forEach { export(it) }
    mppLibs.forEach { export(it) }
    merseyModules.forEach { export(it) }
}