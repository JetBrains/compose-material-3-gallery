rootProject.name = "Material-3-gallery"
include(":composeApp")

pluginManagement {
    @Suppress("LocalVariableName")
    val kotlin_version: String? by settings
    @Suppress("LocalVariableName")
    val kotlin_repo_url: String? by settings

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        kotlin_repo_url?.also { maven(it) }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }

    plugins {
        println("kotlin_version = $kotlin_version")
        val kotlinVersion = extra.properties["community.project.kotlin.version"] as? String
            ?: kotlin_version
            ?: "1.9.21"
        println("Final kotlin version = $kotlinVersion")
        val composeVersion = extra["composeMpp.version"] as String
        println("compose_version = $composeVersion")
        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        id("org.jetbrains.kotlin.plugin.compose").version(kotlinVersion)
        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    @Suppress("LocalVariableName")
    val kotlin_repo_url: String? by settings

    val composeCompilerCustomRepo =
        extra.properties["compose.compiler.customRepositoryUrl"] as? String

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        kotlin_repo_url?.also { maven(it) }
        composeCompilerCustomRepo?.also { maven(it) }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}
