plugins {
    alias(libs.plugins.kotlin.serialization)
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.multiplatform.get().pluginId)
}

val javaVersion = libs.versions.java.get().toInt()

android {
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    namespace = "sisterhood.hitomi"
}

kotlin {
    androidTarget()
    jvm()

    sourceSets {
        commonMain.dependencies {
            api(libs.ktor.client.core)
            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.io.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.mock)
        }
    }

    jvmToolchain(javaVersion)
}
