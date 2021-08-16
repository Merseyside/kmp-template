object Versions {
    const val kotlin = "1.5.30-RC"

    object Plugins {
        const val gradle = "4.2.1"

        const val serialization = kotlin
        const val sqlDelight = "1.5.0"
    }

    object Common {
        const val coroutines = "1.5.1-native-mt"
        const val serialization = "1.2.2"

        const val koin = "3.1.2"
        const val mokoMvvm = "0.11.0"
    }

    object Android {
        const val appCompat = "1.2.0"
        const val material = "1.3.0"
        const val constraintLayout = "2.0.4"
        const val navigation = "2.3.5"
        const val lifecycle = "2.3.1"
        const val recyclerView = "1.1.0"
        const val merseyLibs = "1.4.1"
    }

    object MultiPlatform {

        const val ktorClient = "1.6.0"
        const val ktorClientLogging = ktorClient

        const val mokoResources = "0.16.1"
        const val mokoNetwork = "0.15.2"
        const val mokoPermissions = "0.9.0"
        const val mokoParcelize = "0.6.1"

        const val sqlDelight = "1.5.0"
        const val settings = "0.7.7"

        const val merseyLibs = "1.3.6"
    }
}