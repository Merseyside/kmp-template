object Deps {
    
    object Android {
        val appCompat = "androidx.appcompat:appcompat:${Versions.Android.appCompat}"
        val material = "com.google.android.material:material:${Versions.Android.material}"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Common.coroutines}"
        val koin = "io.insert-koin:koin-android:${Versions.Common.koin}"
        val koinExt = "io.insert-koin:koin-android-ext:${Versions.Common.koin}"
        val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.Common.koin}"
        val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.Android.navigation}"
        val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.Android.navigation}"
        val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Common.serialization}"
        val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Android.recyclerView}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
        val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycle}"
        val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.lifecycle}"
        val mokoMvvmDatabinding = "dev.icerock.moko:mvvm-databinding:${Versions.Common.mokoMvvm}"
        val mokoMvvmViewbinding = "dev.icerock.moko:mvvm-viewbinding:${Versions.Common.mokoMvvm}"



        object MerseyLibs {
            private const val base = "com.github.Merseyside.mersey-android-library"
            const val archy = "$base:archy:${Versions.Common.merseyLibs}"
            const val adapters = "$base:adapters:${Versions.Common.merseyLibs}"
            const val animators = "$base:animators:${Versions.Common.merseyLibs}"
            const val utils = "$base:utils:${Versions.Common.merseyLibs}"

            const val archyAndroid = "io.github.merseyside:archy-android:${Versions.Common.merseyLibs}"
        }
    }

    object MultiPlatform {
        const val ktorClient = "io.ktor:ktor-client-core:${Versions.MultiPlatform.ktorClient}"
        const val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.MultiPlatform.ktorClientLogging}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersions.Common.coroutines}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Common.serialization}"

        val koin = "io.insert-koin:koin-core:${LibraryVersions.Common.koin}"
            .defaultMPL(ios = true)
        val mokoParcelize = "dev.icerock.moko:parcelize:${Versions.MultiPlatform.mokoParcelize}"
            .defaultMPL(ios = true)
        val mokoMvvm =  "dev.icerock.moko:mvvm-core:${Versions.Common.mokoMvvm}"
            .defaultMPL(ios = true)
        val mokoMvvmLiveData = "dev.icerock.moko:mvvm-livedata:${LibraryVersions.Common.mokoMvvm}"
            .defaultMPL()
        val mokoResources = "dev.icerock.moko:resources:${Versions.MultiPlatform.mokoResources}"
            .defaultMPL(ios = true)
        val mokoPermissions = "dev.icerock.moko:permissions:${Versions.MultiPlatform.mokoPermissions}"
            .defaultMPL(ios = true)
        val mokoNetwork = "dev.icerock.moko:network:${Versions.MultiPlatform.mokoNetwork}"
            .defaultMPL(ios = true)
        val settings = "com.russhwolf:multiplatform-settings:${Versions.MultiPlatform.settings}"
            .defaultMPL(ios = true)
        val sqlDelight = "com.squareup.sqldelight:runtime:${Versions.MultiPlatform.sqlDelight}"
            .defaultMPL(ios = true)

        object MerseyLibs {
            private const val base = "io.github.merseyside"

            val archy = "$base:archy-core:${Versions.Common.merseyLibs}"
                .defaultMPL()

            val utils = "$base:utils-core:${Versions.Common.merseyLibs}"
                .defaultMPL(
                    android = true
                )
        }
    }
}