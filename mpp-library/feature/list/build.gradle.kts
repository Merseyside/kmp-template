import dependencies.Deps

plugins {
    plugin(Plugins.commonFeature)
}

val mppLibs = listOf(
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.mokoNetwork,
    Deps.MultiPlatform.settings
)

dependencies {
    mppLibs.forEach { lib -> mppLibrary(lib) }
}

