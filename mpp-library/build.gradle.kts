import dependencies.Deps
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import extensions.isLocalDependencies

plugins {
    plugin(Plugins.androidLibrary)
    plugin(Plugins.kotlinMultiplatform)
    plugin(Plugins.mobileMultiplatform)
    plugin(Plugins.multiplatformResources)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val mppLibs = listOf(
    Deps.MultiPlatform.coroutines,
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.settings,
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.mokoResources,
    Deps.MultiPlatform.mokoMvvm,
    Deps.MultiPlatform.mokoUnits
)
val mppModules = listOf(
    Modules.MultiPlatform.domain,
    Modules.MultiPlatform.Feature.list,
    Modules.MultiPlatform.newsApi
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.kmpCleanArch
)

dependencies {
    mppModules.forEach { lib -> mppModule(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { lib -> mppModule(lib) }
    }

    mppLibs.forEach { lib -> mppLibrary(lib) }
}

multiplatformResources {
    multiplatformResourcesPackage = SharedConfig.RESOURCES_PACKAGE
}
