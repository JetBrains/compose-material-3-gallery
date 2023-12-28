import org.jetbrains.compose.ComposeExtension

plugins {
    kotlin("android") apply false
    kotlin("multiplatform") apply false
    kotlin("plugin.serialization") apply false
    id("org.jetbrains.compose") apply false

    alias(libs.plugins.android.application).apply(false)
}


allprojects {
    @Suppress("LocalVariableName")
    val kotlin_repo_url: String? = extra.properties["kotlin_repo_url"] as? String

    val composeCompilerCustomRepo =
        extra.properties["compose.compiler.customRepositoryUrl"] as? String

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://androidx.dev/storage/compose-compiler/repository/")
        kotlin_repo_url?.also { maven(it) }
        composeCompilerCustomRepo?.also { maven(it) }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }

    afterEvaluate {
        extensions.findByType(ComposeExtension::class.java)?.apply {
            val composeCompilerVersion = project.property("compose.compiler") as String
            kotlinCompilerPlugin.set(composeCompilerVersion)

            val kotlinVersion = project.property("kotlin_version") ?: "2.0.0-Beta1"
            kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
        }
    }
}