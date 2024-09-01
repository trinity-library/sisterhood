plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
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
    namespace = "sisterhood.ui"
}

kotlin {
    androidTarget()
    jvm()

    sourceSets {
        commonMain.dependencies {
            api(compose.foundation)
            api(compose.material3)
            api(compose.runtime)
        }

        commonTest.dependencies {

        }
    }

    jvmToolchain(javaVersion)
}
