plugins {
    plugin(Plugins.commonFeature)
}

val mppLibs = listOf(
    Deps.MultiPlatform.mokoParcelize,
    Deps.MultiPlatform.mokoMvvmLiveData,
    //Deps.MultiPlatform.mokoNetwork,
    Deps.MultiPlatform.settings
)

dependencies {
    mppLibs.forEach { lib -> commonMainImplementation(lib.common) }
}

