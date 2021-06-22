plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.10"
}

repositories {
    mavenLocal()
    mavenCentral()

    google()
}

val multiplatform = "0.9.2"
val kotlin = "1.5.10"
val gradle = "4.2.1"
val resources = "0.15.1"
val sqldelight = "1.5.0"

dependencies {
    implementation("com.android.tools.build:gradle:$gradle")
    implementation("dev.icerock:mobile-multiplatform:$multiplatform")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
    implementation("dev.icerock.moko:resources-generator:$resources")
    implementation("com.squareup.sqldelight:gradle-plugin:$sqldelight")
}
