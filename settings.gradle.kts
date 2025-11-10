rootProject.name = "Material-3-gallery"
include(":composeApp")

pluginManagement {
    @Suppress("LocalVariableName")
    val kotlin_version: String? by settings
    @Suppress("LocalVariableName")
    val kotlin_repo_url: String? by settings

    val kotlinVersionDot = providers.gradleProperty("kotlin.version").orNull
    val kotlinRepoDot = providers.gradleProperty("kotlin.repo").orNull

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        (kotlinRepoDot ?: kotlin_repo_url)?.takeIf { it.isNotBlank() }?.let { maven(it) }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }

    plugins {
        println("kotlin_version (underscore) = $kotlin_version")
        println("kotlin.version (dot) = $kotlinVersionDot")
        val kotlinVersion = kotlinVersionDot
            ?: kotlin_version
            ?: "2.2.21"
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

    val kotlinRepoDot = providers.gradleProperty("kotlin.repo").orNull

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        (kotlinRepoDot ?: kotlin_repo_url)?.takeIf { it.isNotBlank() }?.let { maven(it) }
        composeCompilerCustomRepo?.takeIf { it.isNotBlank() }?.let { maven(it) }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}
