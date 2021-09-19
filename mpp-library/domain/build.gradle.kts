plugins {
    id(Plugins.versionCatalog)
    id(Plugins.androidLibrary)
    id(Plugins.kotlinMultiplatform)
    id(Plugins.kotlinSerialization)
    id(Plugins.mobileMultiplatform)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }
}

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.koin,
    libs.multiplatform.settings,
    libs.multiplatform.sqldelight
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
    mppLibs.forEach { lib -> commonMainApi(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib) }
    }
}
