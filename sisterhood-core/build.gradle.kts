plugins {
    alias(libs.plugins.sqldelight)
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
    namespace = "sisterhood.core"
}

kotlin {
    androidTarget()
    jvm()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.kotlinx.io.core)
            implementation(libs.sqldelight.android.driver)
        }

        commonMain.dependencies {
            api(project(":sisterhood-hitomi"))
            api(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.cio)
            implementation(libs.sqldelight.coroutines.extensions)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        jvmMain.dependencies {
            implementation(libs.kotlinx.coroutines.core.jvm)
            implementation(libs.kotlinx.io.core.jvm)
            implementation(libs.slf4j.simple)
            implementation(libs.sqldelight.sqlite.driver)
        }

        jvmTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    jvmToolchain(javaVersion)
}

sqldelight {
    databases {
        create("Sqlite") {
            dialect(libs.sqldelight.sqlite.dialect)
            generateAsync.set(true)
            packageName.set("sisterhood.infrastructure.sqldelight")
            srcDirs("src/commonMain/sqlite")
        }
    }
}
