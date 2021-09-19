plugins {
    id(Plugins.commonFeature)
}

val mppLibs = listOf(
    libs.multiplatform.settings
)

dependencies {
    mppLibs.forEach { lib -> commonMainImplementation(lib) }
}