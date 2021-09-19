plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()

    google()
}

val multiplatform = "0.12.0"
val kotlin = "1.5.30"
val gradle = "4.2.1"
val resources = "0.15.1"
val sqldelight = "1.5.0"
val navigation = "2.3.5"

dependencies {
    // hack to access version catalog https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation("com.android.tools.build:gradle:$gradle")
    implementation("dev.icerock:mobile-multiplatform:$multiplatform")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
    implementation("dev.icerock.moko:resources-generator:$resources")
    implementation("com.squareup.sqldelight:gradle-plugin:$sqldelight")



}
