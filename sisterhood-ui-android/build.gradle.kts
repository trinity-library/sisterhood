plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.multiplatform.get().pluginId)
}

val javaVersion = libs.versions.java.get().toInt()

android {
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    defaultConfig {
        applicationId = "io.github.trinity_library.Sisterhood"
        minSdk = 26
        targetSdk = 34
    }
    namespace = "sisterhood.ui.android"
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":sisterhood-core"))
                implementation(project(":sisterhood-ui"))

                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.core.ktx)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.slf4j.simple)
            }
        }

        androidNativeTest.dependencies {
        }
    }
    jvmToolchain(javaVersion)
}
