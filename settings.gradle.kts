include(
    ":android-app",
    ":mpp-library",
    ":mpp-library:domain",
    ":mpp-library:core",

    ":mpp-library:feature:news",
    ":mpp-library:library:newsApi"
)

private val isLocalDependencies = false

if (isLocalDependencies) {

    include(":archy-core")
    project(":archy-core").projectDir =
        File(rootDir.parent, "mersey-kmp-library/archy-core")

    include(":utils-core")
    project(":utils-core").projectDir =
        File(rootDir.parent, "mersey-kmp-library/utils-core")

    include(":archy-android")
    project(":archy-android").projectDir =
        File(rootDir.parent, "mersey-kmp-library/archy-android")

    include(":utils")
    project(":utils").projectDir =
        File(rootDir.parent, "mersey-android-library/utils")

    include(":animators")
    project(":animators").projectDir =
        File(rootDir.parent, "mersey-android-library/animators")

    include(":archy")
    project(":archy").projectDir =
        File(rootDir.parent, "mersey-android-library/archy")

    include(":adapters")
    project(":adapters").projectDir =
        File(rootDir.parent, "mersey-android-library/adapters")
}