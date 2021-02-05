/**
 * Configuration of all gradle build plugins
 */
object Plugins {
    val androidApplication = PluginDesc(id = "com.android.application")
    val androidLibrary = PluginDesc(id = "com.android.library")
    val androidFeature = PluginDesc(id = "android-feature")
    val commonFeature = PluginDesc(id = "common-feature")
    val kotlinKapt = PluginDesc(id = "kotlin-kapt")
    val kotlinAndroid = PluginDesc(id = "kotlin-android")
    val mobileMultiplatform = PluginDesc(id = "dev.icerock.mobile.multiplatform")
    val dynamicFeature = PluginDesc(id = "com.android.dynamic-feature")
    val commonsDynamicFeature = PluginDesc(id = "commons.android-dynamic-feature")
    val updateDependencies = PluginDesc(id = "plugins.update-dependencies")
    val detekt = PluginDesc(id = "plugins.detekt")
    val navigationArgs = PluginDesc(id = "androidx.navigation.safeargs.kotlin")
    val kotlinParcelize = PluginDesc(id = "kotlin-parcelize")
    val multiplatformResources = PluginDesc(id = "dev.icerock.mobile.multiplatform-resources")

    val sqlDelight = PluginDesc(
        id = "com.squareup.sqldelight",
        module = "com.squareup.sqldelight:gradle-core.plugins.plugin:${Versions.Plugins.sqlDelight}"
    )

    val kotlinMultiplatform = PluginDesc(
        id = "org.jetbrains.kotlin.multiplatform",
        module = "org.jetbrains.kotlin:kotlin-gradle-core.plugins.plugin:${Versions.kotlin}"
    )

    val kotlinSerialization = PluginDesc(
        id = "kotlinx-serialization",
        module = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Plugins.serialization}"
    )
}
