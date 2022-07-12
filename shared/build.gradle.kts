import com.lukninja.dependencies.Deps
import com.lukninja.dependencies.Version

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
    id("com.squareup.sqldelight")
    id("com.android.library")
}

version = "1.0"

sqldelight {
    database("YourAppNameDatabase") {
        packageName = "com.yourappname.database"
        sourceFolders = listOf("sqldelight")
    }
}


kotlin {
    android()


    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "Your App KMM Shared Module"
        homepage = "N/A"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            export(com.lukninja.dependencies.Deps.Log.kermit)
            isStatic = true
        }

        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] =
            org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] =
            org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.RELEASE
    }


    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(com.lukninja.dependencies.Deps.Kotlin.dateTime)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorClientCore)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorClientSerialization)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorLog)
                implementation(com.lukninja.dependencies.Deps.Kotlin.coroutinesShared){
                    version{
                        strictly(com.lukninja.dependencies.Version.kotlinCoroutinesVersion)
                    }
                }
                implementation(com.lukninja.dependencies.Deps.Kotlin.serialization)
                implementation(com.lukninja.dependencies.Deps.SqlDelight.sqlDelightRuntime)
                implementation(com.lukninja.dependencies.Deps.SqlDelight.sqlDelightCoroutineExtensions)
                api(com.lukninja.dependencies.Deps.Log.kermit)
                implementation(com.lukninja.dependencies.Deps.Log.kermitCrashlytics)
                implementation(com.lukninja.dependencies.Deps.Touchlab.commonLib)
                implementation(com.lukninja.dependencies.Deps.Koin.koinCore)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorContentNegotiation)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorJson)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorEncoding)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }


        val androidMain by getting {
            dependencies {
                implementation(com.lukninja.dependencies.Deps.Kotlin.kotlinStdLib)
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorClientAndroid)
                implementation(com.lukninja.dependencies.Deps.SqlDelight.sqlDelightAndroid)
                implementation(com.lukninja.dependencies.Deps.Klock.klockLib)
                implementation(com.lukninja.dependencies.Deps.Koin.koinClientAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }


        val iosMain by getting {
            dependencies {
                implementation(com.lukninja.dependencies.Deps.Ktor.ktorClientIos)
                implementation(com.lukninja.dependencies.Deps.SqlDelight.sqlDelightIos)
                api(com.lukninja.dependencies.Deps.Touchlab.crashKiOSClient)
            }
        }
    }
}


kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {
    binaries.all {
        binaryOptions["memoryModel"] = "experimental"
        binaryOptions["freezing"] = "disabled"
    }
}


android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}