rootProject.name = "Material-3-gallery"
include(":shared")
include(":androidApp")

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
