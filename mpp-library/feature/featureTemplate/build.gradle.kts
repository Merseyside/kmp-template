plugins {
    plugin(Plugins.commonFeature)
}

val mppLibs = listOf(
    Deps.MultiPlatform.settings
)

dependencies {
    mppLibs.forEach { lib -> commonMainImplementation(lib.common) }
}