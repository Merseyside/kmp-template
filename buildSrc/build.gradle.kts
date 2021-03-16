plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.serialization") version "1.4.31"
}

repositories {
    mavenLocal()

    jcenter()
    google()

    maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }
}

val multiplatform = "0.9.0"
val kotlin = "1.4.31"
val gradle = "4.1.1"
val resources = "0.15.0"
val mavenVersion = "2.1"
val sqldelight = "1.4.4"

dependencies {
    implementation("com.android.tools.build:gradle:$gradle")
    implementation("dev.icerock:mobile-multiplatform:$multiplatform")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
    implementation("dev.icerock.moko:resources-generator:$resources")
    implementation("com.squareup.sqldelight:gradle-plugin:$sqldelight")
    implementation("com.github.dcendents:android-maven-gradle-plugin:$mavenVersion")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
