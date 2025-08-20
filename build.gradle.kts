plugins {
    kotlin("android") apply false
    kotlin("multiplatform") apply false
    kotlin("plugin.serialization") apply false
    id("org.jetbrains.compose") apply false
    id("org.jetbrains.kotlin.plugin.compose") apply false

    alias(libs.plugins.android.application).apply(false)
}


allprojects {
    @Suppress("LocalVariableName")
    val kotlin_repo_url: String? = extra.properties["kotlin_repo_url"] as? String

    val kotlinRepoDot: String? = providers.gradleProperty("kotlin.repo").orNull

    val composeCompilerCustomRepo =
        extra.properties["compose.compiler.customRepositoryUrl"] as? String

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://androidx.dev/storage/compose-compiler/repository/")
        (kotlinRepoDot ?: kotlin_repo_url)?.takeIf { it.isNotBlank() }?.let { maven(it) }
        composeCompilerCustomRepo?.takeIf { it.isNotBlank() }?.let { maven(it) }
//        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        maven("https://packages.jetbrains.team/maven/p/kt/dev/")
    }
}
