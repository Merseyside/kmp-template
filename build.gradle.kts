allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()

        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}
