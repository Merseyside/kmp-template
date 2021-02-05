object Versions {
    const val kotlin = "1.4.30"

    object Plugins {
        const val gradle = "4.1.1"

        const val serialization = kotlin
        const val sqlDelight = "1.4.4"
    }

    object Common {
        const val coroutines = "1.3.8"
        const val serialization = "1.0.1"
        const val merseyLibs = "1.3.0"
        const val koin = "3.0.0-alpha-4"
    }

    object Android {
        const val appCompat = "1.2.0"
        const val material = "1.2.1"
        const val constraintLayout = "2.1.0-alpha2"
        const val navigation = "2.3.2"
        const val lifecycle = "2.3.0-rc01"
        const val recyclerView = "1.1.0"
        const val mokoMvvm = "0.9.1"
    }

    object MultiPlatform {
        const val kotlinStdLib = kotlin

        const val ktorClient = "1.5.1"
        const val ktorClientLogging = ktorClient

        const val mokoMvvm = "0.9.1"
        const val mokoResources = "0.14.0"
        const val mokoNetwork = "0.9.1"
        const val mokoUnits = "0.4.1"
        const val mokoPermissions = "0.7.0"
        const val mokoParcelize = "0.5.0"

        const val settings = "0.7.1"
    }
}