package dependencies

import AndroidLibrary
import MultiPlatformLibrary
import Versions

object Deps {
    
    object Android {
        val appCompat = AndroidLibrary(
            name = "androidx.appcompat:appcompat:${Versions.Android.appCompat}"
        )
        val material = AndroidLibrary(
            name = "com.google.android.material:material:${Versions.Android.material}"
        )
        val coroutines = AndroidLibrary(
            name = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Common.coroutines}"
        )
        val koinViewModels = AndroidLibrary(
            name = "org.koin:koin-androidx-viewmodel:${Versions.Common.koin}"
        )
        val koinExt = AndroidLibrary(
            name = "org.koin:koin-androidx-ext:${Versions.Common.koin}"
        )
        val navigation = AndroidLibrary(
            name = "androidx.navigation:navigation-fragment-ktx:${Versions.Android.navigation}"
        )
        val navigationUi = AndroidLibrary(
            name = "androidx.navigation:navigation-ui-ktx:${Versions.Android.navigation}"
        )
        val serialization = AndroidLibrary(
            name = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Common.serialization}"
        )
        val recyclerView = AndroidLibrary(
            name = "androidx.recyclerview:recyclerview:${Versions.Android.recyclerView}"
        )
        val constraintLayout = AndroidLibrary(
            name = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
        )
        val lifecycleViewModel = AndroidLibrary(
            name = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycle}"
        )
        val lifecycleLiveDataKtx = AndroidLibrary(
            name = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.lifecycle}"
        )
        val mokoMvvmDatabinding = AndroidLibrary(
            name = "dev.icerock.moko:mvvm-databinding:${Versions.Android.mokoMvvm}"
        )
        val mokoMvvmViewbinding = AndroidLibrary(
            name = "dev.icerock.moko:mvvm-viewbinding:${Versions.Android.mokoMvvm}"
        )

        object MerseyLibs {
            private const val base = "com.github.Merseyside.mersey-android-library"
            const val archy = "$base:archy:${Versions.Common.merseyLibs}"
            const val adapters = "$base:adapters:${Versions.Common.merseyLibs}"
            const val animators = "$base:animators:${Versions.Common.merseyLibs}"
            const val utils = "$base:utils:${Versions.Common.merseyLibs}"
        }
    }

    object MultiPlatform {
        val kotlinStdLib = MultiPlatformLibrary(
            common = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.MultiPlatform.kotlinStdLib}"
        )
        val ktorClient = MultiPlatformLibrary(
            android = "io.ktor:ktor-client-android:${Versions.MultiPlatform.ktorClient}",
            common = "io.ktor:ktor-client-core:${Versions.MultiPlatform.ktorClient}",
            iosX64 = "io.ktor:ktor-client-ios:${Versions.MultiPlatform.ktorClient}",
            iosArm64 = "io.ktor:ktor-client-ios:${Versions.MultiPlatform.ktorClient}"
        )
        val ktorClientLogging = MultiPlatformLibrary(
            common = "io.ktor:ktor-client-logging:${Versions.MultiPlatform.ktorClientLogging}"
        )
        val koin = MultiPlatformLibrary(
            common = "org.koin:koin-core:${Versions.Common.koin}"
        )
        val coroutines = MultiPlatformLibrary(
            android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.Common.coroutines}",
            common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersions.Common.coroutines}",
            iosX64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:${LibraryVersions.Common.coroutines}",
            iosArm64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosarm64:${LibraryVersions.Common.coroutines}"
        )
        val serialization = MultiPlatformLibrary(
            common = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Common.serialization}"
        )
        val mokoParcelize = MultiPlatformLibrary(
            common = "dev.icerock.moko:parcelize:${Versions.MultiPlatform.mokoParcelize}",
            iosX64 = "dev.icerock.moko:parcelize-iosx64:${Versions.MultiPlatform.mokoParcelize}",
            iosArm64 = "dev.icerock.moko:parcelize-iosarm64:${Versions.MultiPlatform.mokoParcelize}"
        )
        val mokoMvvm = MultiPlatformLibrary(
            common = "dev.icerock.moko:mvvm:${Versions.Common.mokoMvvm}",
            iosX64 = "dev.icerock.moko:mvvm-iosx64:${Versions.Common.mokoMvvm}",
            iosArm64 = "dev.icerock.moko:mvvm-iosarm64:${Versions.Common.mokoMvvm}"
        )
        val mokoResources = MultiPlatformLibrary(
            common = "dev.icerock.moko:resources:${Versions.MultiPlatform.mokoResources}",
            iosX64 = "dev.icerock.moko:resources-iosx64:${Versions.MultiPlatform.mokoResources}",
            iosArm64 = "dev.icerock.moko:resources-iosarm64:${Versions.MultiPlatform.mokoResources}"
        )
        val mokoPermissions = MultiPlatformLibrary(
            common = "dev.icerock.moko:permissions:${Versions.MultiPlatform.mokoPermissions}",
            iosX64 = "dev.icerock.moko:permissions-iosx64:${Versions.MultiPlatform.mokoPermissions}",
            iosArm64 = "dev.icerock.moko:permissions-iosarm64:${Versions.MultiPlatform.mokoPermissions}"
        )
        val mokoNetwork = MultiPlatformLibrary(
            common = "dev.icerock.moko:network:${Versions.MultiPlatform.mokoNetwork}",
            iosX64 = "dev.icerock.moko:network-iosx64:${Versions.MultiPlatform.mokoNetwork}",
            iosArm64 = "dev.icerock.moko:network-iosarm64:${Versions.MultiPlatform.mokoNetwork}"
        )
        val mokoUnits = MultiPlatformLibrary(
            common = "dev.icerock.moko:units:${Versions.MultiPlatform.mokoUnits}",
            iosX64 = "dev.icerock.moko:units-iosx64:${Versions.MultiPlatform.mokoUnits}",
            iosArm64 = "dev.icerock.moko:units-iosarm64:${Versions.MultiPlatform.mokoUnits}"
        )
        val settings = MultiPlatformLibrary(
            common = "com.russhwolf:multiplatform-settings:${Versions.MultiPlatform.settings}"
        )
        val sqlDelight = MultiPlatformLibrary(
            common = "com.squareup.sqldelight:runtime:${Versions.MultiPlatform.sqlDelight}",
            android = "com.squareup.sqldelight:android-driver:${Versions.MultiPlatform.sqlDelight}",
            iosArm64 = "com.squareup.sqldelight:native-driver:${Versions.MultiPlatform.sqlDelight}",
            iosX64 = "com.squareup.sqldelight:native-driver:${Versions.MultiPlatform.sqlDelight}"
        )

        object MerseyLibs {
            private const val base = "com.github.Merseyside.mersey-android-library"

            val kmpCleanArch = MultiPlatformLibrary(
                common = "$base:kmp-clean-mvvm-arch:${Versions.Common.merseyLibs}",
                android = "$base:kmp-clean-mvvm-arch-android:${Versions.Common.merseyLibs}"
            )

            val kmpUtils = MultiPlatformLibrary(
                common = "$base:kmp-utils:${Versions.Common.merseyLibs}",
                android = "$base:kmp-utils-android:${Versions.Common.merseyLibs}"
            )
        }
    }
}