rootProject.name = "sisterhood"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":sisterhood-core")
include(":sisterhood-hitomi")
include(":sisterhood-ui")
include(":sisterhood-ui-android")
include(":sisterhood-ui-desktop")
