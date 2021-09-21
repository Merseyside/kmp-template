/**
 * Configuration of all gradle build plugins
 */
object Plugins {
    val androidApplication = "com.android.application"
    val androidLibrary = "com.android.library"
    val androidFeature = "android-feature"
    val androidConvention = "commons.android-convention"
    val kotlinMultiplatform = "org.jetbrains.kotlin.multiplatform"
    val versionCatalog = "commons.version-catalogs"
    val commonFeature = "common-feature"
    val commonCoreFeature = "common-core-feature"
    val kotlinKapt = "kotlin-kapt"
    val kotlinAndroid = "kotlin-android"
    val mobileMultiplatform = "dev.icerock.mobile.multiplatform"
    val dynamicFeature = "com.android.dynamic-feature"
    val commonsDynamicFeature = "commons.android-dynamic-feature"
    val updateDependencies = "plugins.update-dependencies"
    val detekt = "plugins.detekt"
    val navigationArgs = "androidx.navigation.safeargs.kotlin"
    val kotlinParcelize = "kotlin-parcelize"
    val multiplatformResources = "dev.icerock.mobile.multiplatform-resources"
    val iosFramework = "dev.icerock.mobile.multiplatform.ios-framework"
    val cocoaPods = "org.jetbrains.kotlin.native.cocoapods"
    val sqldelight = "com.squareup.sqldelight"
    val kotlinSerialization = "kotlinx-serialization"
    val mavenPublish = "maven-publish"
    val mavenPublishConfig = "publication.maven-publish-config"
    val resources = "dev.icerock.mobile.multiplatform-resources"

}
