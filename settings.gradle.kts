rootProject.name = "Material-3-gallery"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":shared")
include(":androidApp")
include(":desktopApp")
include(":webApp")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/cmp/dev")
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/cmp/dev")
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
    }
}
