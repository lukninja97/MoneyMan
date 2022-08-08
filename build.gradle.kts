import com.lukninja.dependencies.Deps

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        with(com.lukninja.dependencies.Deps.Classpath) {
            classpath(kotlin)
            classpath(androidTools)
            classpath(sqlDelight)
            classpath(serialization)
            classpath(safeArgs)
        }
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}