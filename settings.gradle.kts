include(
    ":android-app",
    ":mpp-library",
    ":mpp-library:domain",
    ":mpp-library:core"
)

private val isLocalDependencies = true
private val isLocalAndroidDependencies = false

if (isLocalDependencies) {

    include(":archy-core")
    project(":archy-core").projectDir =
        File(rootDir, "kmm-support-library/archy-core")

    include(":utils-core")
    project(":utils-core").projectDir =
        File(rootDir, "kmm-support-library/utils-core")

    include(":archy-android")
    project(":archy-android").projectDir =
        File(rootDir, "kmm-support-library/archy-android")
}

if (isLocalAndroidDependencies) {
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