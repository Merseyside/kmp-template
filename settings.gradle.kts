enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

private val isLocalDependencies = false
private val isLocalAndroidDependencies = false

if (isLocalDependencies || isLocalAndroidDependencies) {
    dependencyResolutionManagement {
        repositories {
            mavenCentral()
            mavenLocal()
        }

        val group = "io.github.merseyside"
        val catalogVersions = "1.1.0"
        versionCatalogs {
            val multiplatformLibs by creating {
                from("$group:catalog-version-multiplatform:$catalogVersions")
            }

            val androidLibs by creating {
                from("$group:catalog-version-android:$catalogVersions")
            }

            val common by creating {
                from("$group:catalog-version-common:$catalogVersions")
            }
        }
    }
}

include(
    ":android-app",
    ":mpp-library",
    ":mpp-library:domain",
    ":mpp-library:core"
)

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