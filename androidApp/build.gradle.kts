import com.lukninja.dependencies.Deps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id ("androidx.navigation.safeargs.kotlin")
    kotlin("android")
    id ("kotlinx-serialization")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.lukninja.moneyman.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}

dependencies {
    api(project(":shared")) {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
    }

    implementation(Deps.Material.material)

    implementation(Deps.AppCompat.appCompat)

    implementation(Deps.ConstraintLayout.constraintLayout)

    implementation(Deps.Navigation.fragment)
    implementation(Deps.Navigation.ui)

    implementation(Deps.LifeCycle.liveData)
    implementation(Deps.LifeCycle.viewModel)

    implementation(Deps.Koin.koinClientAndroid)

    implementation(Deps.Preferences.preferences)

    implementation(Deps.DataStore.dataStore)

    implementation(Deps.Android.activity)
    implementation(Deps.Android.fragment)
    implementation(Deps.Android.viewPager)
    implementation(Deps.Android.playServicesLocation)
    implementation(Deps.Android.core)
    implementation(Deps.Android.cardview)

    implementation(Deps.Kotlin.serialization)
    implementation(Deps.Kotlin.kotlinPlayServicesCoroutines)

    implementation(Deps.Timber.timberLog)

    coreLibraryDesugaring(Deps.Desugaring.desugaringLibrary)
}