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
}

multiplatformResources {
    multiplatformResourcesPackage = SharedConfig.RESOURCES_PACKAGE
}

val mppLibs = listOf(
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.settings,
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.mokoResources,
    Deps.MultiPlatform.mokoMvvm,
    Deps.MultiPlatform.sqlDelight
)
val mppModules = listOf(
    Modules.MultiPlatform.domain,
    Modules.MultiPlatform.Feature.news
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.archy
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.archy
)

dependencies {
    commonMainImplementation(project(Modules.MultiPlatform.core.name))
    commonMainImplementation(Deps.MultiPlatform.coroutines)

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainApi(project(module.name)) }
    } else {
        merseyLibs.forEach { lib -> commonMainApi(lib.common) }
    }

    mppModules.forEach { module -> commonMainApi(project(module.name)) }
    mppLibs.forEach { lib -> commonMainApi(lib.common) }
}

framework {
    mppModules.forEach { export(it) }
    mppLibs.forEach { export(it) }
    merseyModules.forEach { export(it) }
}