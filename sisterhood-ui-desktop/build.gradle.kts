import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    id(libs.plugins.kotlin.multiplatform.get().pluginId)
}

kotlin {
    jvm()
    sourceSets {
        jvmMain.dependencies {
            implementation(project(":sisterhood-core"))
            implementation(project(":sisterhood-ui"))
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.cio)
        }

        jvmTest.dependencies {
        }
    }
}

compose.desktop {
    application {
        mainClass = "sisterhood.ui.MainKt"
        nativeDistributions {
            packageName = "Sisterhood"
            packageVersion = "0.1.0"
            targetFormats(TargetFormat.Msi)
        }
    }
}
