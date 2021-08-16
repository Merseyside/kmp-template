
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    plugin(Plugins.androidLibrary)
    plugin(Plugins.kotlinMultiplatform)
    plugin(Plugins.kotlinSerialization)
    plugin(Plugins.mobileMultiplatform)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

val mppLibs = listOf(
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.settings,
    Deps.MultiPlatform.sqlDelight
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

    mppLibs.forEach { lib -> commonMainApi(lib.common) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module.name)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib.common) }
    }
}
