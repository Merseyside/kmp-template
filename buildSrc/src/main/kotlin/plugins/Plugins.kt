/**
 * Configuration of all gradle build plugins
 */
object Plugins {
    val androidApplication = GradlePlugin(id = "com.android.application")
    val androidLibrary = GradlePlugin(id = "com.android.library")
    val androidFeature = GradlePlugin(id = "android-feature")
    val kotlinMultiplatform = GradlePlugin(id = "org.jetbrains.kotlin.multiplatform")
    val commonFeature = GradlePlugin(id = "common-feature")
    val kotlinKapt = GradlePlugin(id = "kotlin-kapt")
    val kotlinAndroid = GradlePlugin(id = "kotlin-android")
    val mobileMultiplatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
    val dynamicFeature = GradlePlugin(id = "com.android.dynamic-feature")
    val commonsDynamicFeature = GradlePlugin(id = "commons.android-dynamic-feature")
    val updateDependencies = GradlePlugin(id = "plugins.update-dependencies")
    val detekt = GradlePlugin(id = "plugins.detekt")
    val navigationArgs = GradlePlugin(id = "androidx.navigation.safeargs.kotlin")
    val kotlinParcelize = GradlePlugin(id = "kotlin-parcelize")
    val multiplatformResources = GradlePlugin(id = "dev.icerock.mobile.multiplatform-resources")
    val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
    val cocoaPods = GradlePlugin(id = "org.jetbrains.kotlin.native.cocoapods")

    val sqlDelight = GradlePlugin(
        id = "com.squareup.sqldelight",
        module = "com.squareup.sqldelight:gradle-core.plugins.plugin:${Versions.Plugins.sqlDelight}"
    )

    val kotlinSerialization = GradlePlugin(
        id = "kotlinx-serialization",
        module = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Plugins.serialization}"
    )
}
