package com.lukninja.dependencies

object Version {

    const val kotlin = "1.6.20"
    const val ktorVersion = "2.0.0"
    const val serializationVersion = "1.3.2"
    const val sqlDelightVersion = "1.5.3"
    const val kotlinCoroutinesVersion = "1.6.0-native-mt"
    const val kermitVersion = "1.0.3"
    const val klockVersion = "2.2.2"
    const val crashkIos = "0.4.0"
    const val koin = "3.1.4"
    const val gradleAGPPlugin = "7.2.1"
    const val kotlinDateTimeVersion = "0.3.1"
    const val materialVersion = "1.5.0"
    const val appCompatVersion = "1.3.1"
    const val constraintVersion = "2.1.0"
    const val navigationVersion = "2.4.2"
    const val lifeCycleVersion = "2.4.1"
    const val preferencesVersion = "1.1.1"
    const val dataStoreVersion = "1.0.0"
    const val activityVersion = "1.6.0-alpha03"
    const val fragmentVersion = "1.5.0"
    const val viewPager = "1.0.0"
    const val coreVersion = "1.0.2"
    const val playServicesLocationVersion = "18.0.0"
    const val safeArgs = "2.4.2"
}

object Deps {
    object Classpath {
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val androidTools = "com.android.tools.build:gradle:${Version.gradleAGPPlugin}"
        const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Version.sqlDelightVersion}"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.safeArgs}"
    }

    object Ktor {
        const val ktorClientCore = "io.ktor:ktor-client-core:${Version.ktorVersion}"
        const val ktorClientSerialization =
            "io.ktor:ktor-client-serialization:${Version.ktorVersion}"
        const val ktorClientIos = "io.ktor:ktor-client-ios:${Version.ktorVersion}"
        const val ktorClientAndroid = "io.ktor:ktor-client-android:${Version.ktorVersion}"
        const val ktorLog = "io.ktor:ktor-client-logging:${Version.ktorVersion}"
        const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktorVersion}"
        const val ktorJson = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktorVersion}"
        const val ktorEncoding =  "io.ktor:ktor-client-encoding:${Version.ktorVersion}"
        const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Version.ktorVersion}"
    }

    object Klock {
        const val klockLib = "com.soywiz.korlibs.klock:klock:${Version.klockVersion}"
    }

    object Koin {
        const val koinCore = "io.insert-koin:koin-core:${Version.koin}"
        const val koinClientAndroid = "io.insert-koin:koin-android:${Version.koin}"
    }

    object Touchlab {
        const val commonLib = "co.touchlab:stately-common:1.1.4"
        const val crashKiOSClient = "co.touchlab:crashkios:${Version.crashkIos}"
    }

    object SqlDelight {
        const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:${Version.sqlDelightVersion}"
        const val sqlDelightCoroutineExtensions =
            "com.squareup.sqldelight:coroutines-extensions:${Version.sqlDelightVersion}"
        const val sqlDelightIos = "com.squareup.sqldelight:native-driver:${Version.sqlDelightVersion}"
        const val sqlDelightAndroid = "com.squareup.sqldelight:android-driver:${Version.sqlDelightVersion}"
    }

    object Log {
        const val kermit = "co.touchlab:kermit:${Version.kermitVersion}"
        const val kermitCrashlytics = "co.touchlab:kermit-crashlytics:${Version.kermitVersion}"
    }

    object Kotlin {
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serializationVersion}"
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib"
        const val coroutinesShared =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutinesVersion}"
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.kotlinDateTimeVersion}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Version.materialVersion}"
    }

    object AppCompat {
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompatVersion}"
    }

    object ConstraintLayout {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintVersion}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigationVersion}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Version.navigationVersion}"
    }

    object LifeCycle {
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifeCycleVersion}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifeCycleVersion}"
    }

    object Preferences{
        const val preferences = "androidx.preference:preference-ktx:${Version.preferencesVersion}"
    }

    object DataStore{
        const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStoreVersion}"
    }
    object Android {
        const val activity = "androidx.activity:activity-ktx:${Version.activityVersion}"
        const val fragment = "androidx.fragment:fragment-ktx:${Version.fragmentVersion}"
        const val viewPager = "androidx.viewpager2:viewpager2:${Version.viewPager}"
        const val core = "androidx.core:core-ktx:${Version.coreVersion}"
        const val playServicesLocation = "com.google.android.gms:play-services-location:${Version.playServicesLocationVersion}"
    }
}