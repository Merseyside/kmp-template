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

        val newsApi = MultiPlatformModule("$mppLibrary:library:newsApi")
        val domain = MultiPlatformModule("$mppLibrary:domain")

        object Feature {
            val config = MultiPlatformModule("$mppLibrary:feature:config")
            val list = MultiPlatformModule("$mppLibrary:feature:list")
        }
    }
}