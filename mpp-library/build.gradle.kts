import dependencies.Deps
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import extensions.isLocalDependencies
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    plugin(Plugins.androidLibrary)
    plugin(Plugins.kotlinMultiplatform)
    plugin(Plugins.mobileMultiplatform)
    plugin(Plugins.multiplatformResources)
    plugin(Plugins.iosFramework)
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

kotlin {
    android()

    //iOS
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    targets.getByName<KotlinNativeTarget>("ios") {
        binaries.framework {
            baseName = "common"
            linkerOpts.add("-lsqlite3")
        }
    }
}

val mppLibs = listOf(
    Deps.MultiPlatform.kotlinStdLib,
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.coroutines,
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
    merseyModules.forEach { lib -> mppModule(lib) }
    mppLibs.forEach { lib -> mppLibrary(lib) }
}

framework {
    mppModules.forEach { export(it) }
    mppLibs.forEach { export(it) }
}

multiplatformResources {
    multiplatformResourcesPackage = SharedConfig.RESOURCES_PACKAGE
}
