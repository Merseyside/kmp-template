object LibraryModules {

    const val archy = ":archy"
    const val adapters = ":adapters"
    const val animators = ":animators"
    const val utils = ":utils"

    object MultiPlatform {

        val cleanMvvmArch = MultiPlatformModule(
            name = ":kmp-clean-mvvm-arch",
            exported = true
        )

        val utils = MultiPlatformModule(
            name = ":kmp-utils",
            exported = true
        )
    }
}