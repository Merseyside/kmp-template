object LibraryDeps {
    object Plugins {
        val androidApplication = PluginDesc(id = "com.android.application")
        val kotlinKapt = PluginDesc(id = "kotlin-kapt")
        val kotlinAndroid = PluginDesc(id = "kotlin-android")
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
        val mobileMultiplatform = PluginDesc(id = "dev.icerock.mobile.multiplatform")

        val androidLibrary = PluginDesc(
            id = "com.android.library",
            module = "com.android.tools.build:gradle:${LibraryVersions.Plugins.gradle}"
        )

        val kotlinMultiplatform = PluginDesc(
            id = "org.jetbrains.kotlin.multiplatform",
            module = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibraryVersions.Plugins.kotlin}"
        )

        val kotlinSerialization = PluginDesc(
            id = "kotlinx-serialization",
            module = "org.jetbrains.kotlin:kotlin-serialization:${LibraryVersions.Plugins.serialization}"
        )

        val jitpack = PluginDesc(
            id = "com.github.dcendents.android-maven",
            module = "com.github.dcendents:android-maven-gradle-plugin:${LibraryVersions.Plugins.maven}"
        )

        val resources = PluginDesc(
            id = "dev.icerock.mobile.multiplatform-resources",
            module = "dev.icerock.moko:resources-generator:${LibraryVersions.mokoResources}"
        )

        val mavenPublish = PluginDesc(
            id = "maven-publish"
        )

        val sqldelight = PluginDesc(
            id = "com.squareup.sqldelight",
            module = "com.squareup.sqldelight:gradle-plugin:${LibraryVersions.Plugins.sqlDelight}"
        )

        val kotlinParcelize = PluginDesc(
            id = "kotlin-parcelize"
        )
    }

    object Libs {
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.Libs.coroutines}"
        val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${LibraryVersions.Common.serialization}"
        val appCompat = "androidx.appcompat:appcompat:${LibraryVersions.Libs.appCompat}"
        val material = "com.google.android.material:material:${LibraryVersions.Libs.material}"
        val fragment = "androidx.fragment:fragment:${LibraryVersions.Libs.fragment}"
        val recyclerView = "androidx.recyclerview:recyclerview:${LibraryVersions.Libs.recyclerView}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${LibraryVersions.Libs.constraintLayout}"
        val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersions.Libs.lifecycle}"
        val lifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${LibraryVersions.Libs.lifecycle}"
        val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersions.Libs.lifecycle}"
        val cardView = "androidx.cardview:cardview:${LibraryVersions.Libs.cardView}"
        val annotation = "androidx.annotation:annotation:${LibraryVersions.Libs.annotation}"
        val rxjava2 = "io.reactivex.rxjava2:rxjava:${LibraryVersions.Libs.rxjava2}"
        val paging = "androidx.paging:paging-runtime:${LibraryVersions.Libs.paging}"
        val reflect = "org.jetbrains.kotlin:kotlin-reflect:${LibraryVersions.kotlin}"
        val playCore = "com.google.android.play:core:${LibraryVersions.Libs.playCore}"
        val billing = "com.android.billingclient:billing:${LibraryVersions.Libs.billing}"
        val billingKtx = "com.android.billingclient:billing-ktx:${LibraryVersions.Libs.billing}"
        val publisher = "com.google.apis:google-api-services-androidpublisher:${LibraryVersions.Libs.publisher}"
        val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx:${LibraryVersions.Libs.firebaseFirestore}"
        val oauth2 = "com.google.auth:google-auth-library-oauth2-http:${LibraryVersions.Libs.auth}"
        val room = "androidx.room:room-runtime:${LibraryVersions.Libs.room}"
        val roomCompiler = "androidx.room:room-compiler:${LibraryVersions.Libs.room}"
        val roomKtx = "androidx.room:room-ktx:${LibraryVersions.Libs.room}"
        val koinViewModels = "org.koin:koin-androidx-viewmodel:${LibraryVersions.Common.koin}"
        val koinExt = "org.koin:koin-androidx-ext:${LibraryVersions.Common.koin}"
        val navigation = "androidx.navigation:navigation-fragment-ktx:${LibraryVersions.Libs.navigation}"
        val navigationUi = "androidx.navigation:navigation-ui-ktx:${LibraryVersions.Libs.navigation}"
        val keyboard = "net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:${LibraryVersions.Libs.keyboard}"
        val worker = "androidx.work:work-runtime-ktx:${LibraryVersions.Libs.worker}"
        val gson = "com.google.code.gson:gson:${LibraryVersions.Libs.gson}"
        val coil = "io.coil-kt:coil:${LibraryVersions.Libs.coil}"
        val dagger = "com.google.dagger:dagger:${LibraryVersions.Libs.dagger}"
        val daggerCompiler = "com.google.dagger:dagger-compiler:${LibraryVersions.Libs.dagger}"
        val filemanager = "com.github.Merseyside:android-filemanager:${LibraryVersions.Libs.filemanager}"
        val typedDatastore = "androidx.datastore:datastore:${LibraryVersions.Libs.typedDataStore}"
        val mokoMvvmDatabinding = "dev.icerock.moko:mvvm-databinding:${LibraryVersions.Common.mokoMvvm}"
        val mokoMvvmViewbinding = "dev.icerock.moko:mvvm-viewbinding:${LibraryVersions.Common.mokoMvvm}"

        object MerseyLibs {
            private const val base = "com.github.Merseyside.mersey-android-library"
            val archy = AndroidLibrary(name = "$base:archy:${LibraryVersions.Common.merseyLibs}")
            val utils = AndroidLibrary(name = "$base:utils:${LibraryVersions.Common.merseyLibs}")
        }

        object MultiPlatform {
            val kotlinStdLib = MultiPlatformLibrary(
                android = "org.jetbrains.kotlin:kotlin-stdlib:${LibraryVersions.Common.kotlinStdLib}",
                common = "org.jetbrains.kotlin:kotlin-stdlib-common:${LibraryVersions.Common.kotlinStdLib}"
            )
            val coroutines = MultiPlatformLibrary(
                android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.Common.coroutines}",
                common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersions.Common.coroutines}",
                iosX64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:${LibraryVersions.Common.coroutines}",
                iosArm64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosarm64:${LibraryVersions.Common.coroutines}"
            )
            val serializationJson = MultiPlatformLibrary(
                common = "org.jetbrains.kotlinx:kotlinx-serialization-json:${LibraryVersions.Common.serialization}"
            )
            val serializationProtobuf = MultiPlatformLibrary(
                common = "org.jetbrains.kotlinx:kotlinx-serialization-protobuf:${LibraryVersions.Common.serialization}"
            )
            val ktorClient = MultiPlatformLibrary(
                android = "io.ktor:ktor-client-android:${LibraryVersions.MultiPlatform.ktor}",
                common = "io.ktor:ktor-client-core:${LibraryVersions.MultiPlatform.ktor}",
                iosX64 = "io.ktor:ktor-client-ios:${LibraryVersions.MultiPlatform.ktor}",
                iosArm64 = "io.ktor:ktor-client-ios:${LibraryVersions.MultiPlatform.ktor}"
            )
            val mokoMvvm = MultiPlatformLibrary(
                common = "dev.icerock.moko:mvvm:${LibraryVersions.Common.mokoMvvm}",
                iosX64 = "dev.icerock.moko:mvvm-iosx64:${LibraryVersions.Common.mokoMvvm}",
                iosArm64 = "dev.icerock.moko:mvvm-iosarm64:${LibraryVersions.Common.mokoMvvm}"
            )
            val mokoResources = MultiPlatformLibrary(
                common = "dev.icerock.moko:resources:${LibraryVersions.MultiPlatform.mokoResources}",
                iosX64 = "dev.icerock.moko:resources-iosx64:${LibraryVersions.MultiPlatform.mokoResources}",
                iosArm64 = "dev.icerock.moko:resources-iosarm64:${LibraryVersions.MultiPlatform.mokoResources}"
            )
            val koin = MultiPlatformLibrary(
                common = "org.koin:koin-core:${LibraryVersions.Common.koin}",
                android = "org.koin:koin-android:${LibraryVersions.Common.koin}"
            )
            val sqlDelight = MultiPlatformLibrary(
                common = "com.squareup.sqldelight:runtime:${LibraryVersions.MultiPlatform.sqlDelight}",
                android = "com.squareup.sqldelight:android-driver:${LibraryVersions.MultiPlatform.sqlDelight}"
            )
        }
    }
}