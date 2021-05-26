import dependencies.Deps
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    plugin(Plugins.androidLibrary)
    plugin(Plugins.kotlinMultiplatform)
    plugin(Plugins.mobileMultiplatform)
    plugin(Plugins.multiplatformResources)
    plugin(Plugins.kotlinParcelize)
    plugin(Plugins.iosFramework)
    plugin(Plugins.sqlDelight)
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

    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        val arch = when (this.konanTarget) {
            org.jetbrains.kotlin.konan.target.KonanTarget.IOS_ARM64 -> "iosarm64"
            org.jetbrains.kotlin.konan.target.KonanTarget.IOS_X64 -> "iosx64"
            else -> throw IllegalArgumentException()
        }
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export("${Deps.MultiPlatform.mokoMvvm.common}-$arch:${Versions.Common.mokoMvvm}")
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
    Deps.MultiPlatform.mokoMvvm
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
