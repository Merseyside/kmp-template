object Modules {
    object Android {
        object MerseyLibs {
            const val archy = ":archy"
            const val adapters = ":adapters"
            const val animators = ":animators"
            const val utils = ":utils"
        }
    }

    object MultiPlatform {

        object MerseyLibs {
            val kmpCleanArch = MultiPlatformModule(":kmp-clean-mvvm-arch")
            val kmpUtils = MultiPlatformModule(":kmp-utils")
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