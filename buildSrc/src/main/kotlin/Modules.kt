object Modules {
    object Android {
        object MerseyLibs {
            const val archy = ":archy"
            const val adapters = ":adapters"
            const val animators = ":animators"
            const val utils = ":utils"

            const val archyAndroid = ":archy-android"
        }
    }

    object MultiPlatform {

        object MerseyLibs {
            val archy = MultiPlatformModule(":archy-core")
            val utils = MultiPlatformModule(":utils-core")
        }

        val mppLibrary = ":mpp-library"
        val domain = MultiPlatformModule(
            name = "$mppLibrary:domain",
            exported = true
        )
        val core = MultiPlatformModule(name = "$mppLibrary:core")

        val newsApi = MultiPlatformModule(name = "$mppLibrary:library:newsApi")

        object Feature {
            val config = MultiPlatformModule(
                name = "$mppLibrary:feature:config",
                exported = true
            )
            val news = MultiPlatformModule(
                name = "$mppLibrary:feature:news",
                exported = true
            )
        }
    }
}