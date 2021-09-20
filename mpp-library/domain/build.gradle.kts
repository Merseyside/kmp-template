plugins {
    id(Plugins.versionCatalog)
    `android-convention`
    id(Plugins.kotlinMultiplatform)
    id(Plugins.kotlinSerialization)
    id(Plugins.mobileMultiplatform)
}

val mppLibs = listOf(
    libs.multiplatform.coroutines,
    libs.multiplatform.koin,
    libs.multiplatform.settings,
    libs.multiplatform.sqldelight
)

val merseyModules = listOf(
    Modules.MultiPlatform.MerseyLibs.archy,
    Modules.MultiPlatform.MerseyLibs.utils
)

val merseyLibs = listOf(
    libs.multiplatform.merseyLib.archyCore,
    libs.multiplatform.merseyLib.utilsCore
)

dependencies {
    mppLibs.forEach { lib -> commonMainApi(lib) }

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> commonMainImplementation(project(module)) }
    } else {
        merseyLibs.forEach { lib -> commonMainImplementation(lib) }
    }
}
