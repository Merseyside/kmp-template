
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    plugin(Plugins.androidApplication)
    plugin(Plugins.kotlinAndroid)
    plugin(Plugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        applicationId = AndroidConfig.APPLICATION_ID

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = AndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val androidLibs = listOf(
    Deps.Android.appCompat,
    Deps.Android.navigation,
    Deps.Android.navigationUi,
    Deps.Android.constraintLayout,
    Deps.Android.mokoMvvmDatabinding,
    Deps.Android.mokoMvvmViewbinding,
    Deps.Android.koin,
    Deps.Android.koinExt,
    Deps.Android.material,
    Deps.Android.recyclerView
)

val merseyLibs = listOf(
    Deps.Android.MerseyLibs.archy,
    Deps.Android.MerseyLibs.adapters,
    Deps.Android.MerseyLibs.utils,
    Deps.Android.MerseyLibs.archyAndroid
)

val merseyModules = listOf(
    Modules.Android.MerseyLibs.archy,
    Modules.Android.MerseyLibs.adapters,
    Modules.Android.MerseyLibs.utils,
    Modules.Android.MerseyLibs.archyAndroid
)

dependencies {
    implementation(project(Modules.MultiPlatform.mppLibrary))

    androidLibs.forEach { lib -> implementation(lib) }

    if (isLocalAndroidDependencies()) {
        merseyModules.forEach { lib -> implementation(project(lib)) }
    } else {
        merseyLibs.forEach { lib -> implementation(lib) }
    }

    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}
