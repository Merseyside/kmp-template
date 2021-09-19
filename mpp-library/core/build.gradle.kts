plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("kotlinx-serialization")
    id("dev.icerock.mobile.multiplatform")
    id("com.squareup.sqldelight")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }

}

//val modulez = listOf(
//)

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.serialization,
    libs.multiplatform.ktor,
    libs.multiplatform.ktorLogging,
    libs.multiplatform.koin,
    libs.multiplatform.settings,
    libs.multiplatform.sqldelight
)

val merseyModules = listOf(
    ":utils-core"
)

val merseyLibs = listOf(
    libs.multiplatform.merseyLib.utilsCore
)

dependencies {
    commonMainImplementation(projects.mppLibrary.domain)

    //modulez.forEach { module -> commonMainImplementation(project(module.name)) }
    mppLibs.forEach { lib -> commonMainImplementation(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib) }
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