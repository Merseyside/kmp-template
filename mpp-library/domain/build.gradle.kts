import dependencies.Deps
import extensions.isLocalDependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    plugin(Plugins.androidLibrary)
    plugin(Plugins.kotlinMultiplatform)
    plugin(Plugins.kotlinSerialization)
    plugin(Plugins.mobileMultiplatform)
    plugin(Plugins.sqlDelight)
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

val modulez = listOf(
    Modules.MultiPlatform.Feature.list,
    Modules.MultiPlatform.newsApi
)

val mppLibs = listOf(
    Deps.MultiPlatform.kotlinStdLib,
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.coroutines,
    Deps.MultiPlatform.serialization,
    Deps.MultiPlatform.ktorClient,
    Deps.MultiPlatform.ktorClientLogging,
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.mokoNetwork,
    Deps.MultiPlatform.settings,
    Deps.MultiPlatform.sqlDelight
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.kmpCleanArch,
    Modules.MultiPlatform.MerseyLibs.kmpUtils
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.kmpCleanArch,
    Deps.MultiPlatform.MerseyLibs.kmpUtils
)

dependencies {
    mppLibs.forEach { lib -> mppLibrary(lib) }
    modulez.forEach { module -> mppModule(module) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> mppModule(module) }
    } else {
        merseyLibs.forEach { lib -> mppLibrary(lib) }
    }
}

sqldelight {
    database("TemplateDatabase") {
        packageName = "com.merseyside.template.data.db"
        sourceFolders = listOf("sqldelight")
        schemaOutputDirectory = file("build/dbs")
    }
    linkSqlite = false
}
