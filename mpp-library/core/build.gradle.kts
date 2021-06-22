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
    Modules.MultiPlatform.newsApi
)

val mppLibs = listOf(
    Deps.MultiPlatform.koin,
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.settings,
    Deps.MultiPlatform.sqlDelight
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    Deps.MultiPlatform.MerseyLibs.utils
)

dependencies {
    commonMainImplementation(project(Modules.MultiPlatform.domain.name))

    commonMainImplementation(Deps.MultiPlatform.coroutines)
    commonMainImplementation(Deps.MultiPlatform.serialization)
    commonMainImplementation(Deps.MultiPlatform.ktorClient)
    commonMainImplementation(Deps.MultiPlatform.ktorClientLogging)

    modulez.forEach { module -> commonMainImplementation(project(module.name)) }
    mppLibs.forEach { lib -> commonMainImplementation(lib.common) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module.name)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib.common) }
    }
}

sqldelight {
    database("TemplateDatabase") {
        packageName = "com.merseyside.template.core.db"
        sourceFolders = listOf("sqldelight")
        schemaOutputDirectory = file("build/dbs")
    }
    linkSqlite = true
}