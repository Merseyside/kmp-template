plugins {
    id(Plugins.versionCatalog)
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    compileSdkVersion(Application.compileSdk)

    defaultConfig {
        minSdkVersion(Application.minSdk)
        targetSdkVersion(Application.targetSdk)

        applicationId = Application.applicationId

        versionCode = Application.versionCode
        versionName = Application.version

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    buildFeatures.dataBinding = true

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
    }

    sourceSets.getByName("main") {
        res.srcDir("src/main/res/")
        res.srcDir("src/main/res/layouts/fragments")
        res.srcDir("src/main/res/layouts/activity")
        res.srcDir("src/main/res/layouts/dialog")
        res.srcDir("src/main/res/layouts/views")
        res.srcDir("src/main/res/value/values-light")
        res.srcDir("src/main/res/value/values-night")
    }
}

val androidLib = listOf(
    libs.android.appCompat,
    libs.android.navigation,
    libs.android.navigationUi,
    libs.android.constraintLayout,
    libs.android.koin,
    libs.android.material,
    libs.android.recyclerView
)

val merseyLibs = listOf(
    libs.android.merseyLib.archy,
    libs.android.merseyLib.adapters,
    libs.android.merseyLib.utils,
    libs.android.merseyLib.archyAndroid
)

val merseyModules = listOf(
    Modules.Android.MerseyLibs.archy,
    Modules.Android.MerseyLibs.adapters,
    Modules.Android.MerseyLibs.utils,
    Modules.Android.MerseyLibs.archyAndroid
)

dependencies {
    implementation(projects.mppLibrary)

    androidLib.forEach { lib -> implementation(lib) }
    implementation(libs.bundles.android.moko.mvvm)

    if (isLocalAndroidDependencies()) {
        merseyModules.forEach { lib -> implementation(project(lib)) }
    } else {
        merseyLibs.forEach { lib -> implementation(lib) }
    }

    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}
