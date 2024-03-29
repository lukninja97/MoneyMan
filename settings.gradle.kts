pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MoneyMan"
include(":androidApp")
include(":shared")

rootDir.resolve("gradle.properties").copyTo(
    target = rootDir.resolve("buildSrc").resolve("gradle.properties"),
    overwrite = true
)