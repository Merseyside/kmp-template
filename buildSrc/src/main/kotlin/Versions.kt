object Versions {
    const val kotlin = "1.5.0"

    object Plugins {
        const val gradle = "4.2.1"

        const val serialization = kotlin
        const val sqlDelight = "1.5.0"
    }

    object Common {
        const val coroutines = "1.4.2"
        const val serialization = "1.2.1"
        const val merseyLibs = "1.3.5"
        const val koin = "3.0.2"
        const val mokoMvvm = "0.10.1"
    }

    object Android {
        const val appCompat = "1.2.0"
        const val material = "1.3.0"
        const val constraintLayout = "2.0.4"
        const val navigation = "2.3.2"
        const val lifecycle = "2.3.1"
        const val recyclerView = "1.1.0"
    }

    object MultiPlatform {
        const val kotlinStdLib = kotlin

        const val ktorClient = "1.5.4"
        const val ktorClientLogging = ktorClient

        const val mokoResources = "0.15.1"
        const val mokoNetwork = "0.15.2"
        const val mokoPermissions = "0.9.0"
        const val mokoParcelize = "0.6.1"

        const val sqlDelight = "1.5.0"
        const val settings = "0.7.7"
    }
}