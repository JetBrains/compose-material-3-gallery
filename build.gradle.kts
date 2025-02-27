import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.wasm.nodejs.WasmNodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.web.nodejs.BaseNodeJsRootExtension
import kotlin.collections.plusAssign

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
}

fun configureNpmInstall(extension: BaseNodeJsRootExtension) {
    extension.npmInstallTaskProvider.configure {
        println(name + "HELLO")
        args += listOf("--network-concurrency", "1", "--mutex", "network")
    }
}

plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class) {
    extensions.configure(NodeJsRootExtension::class.java) {
        configureNpmInstall(this)
    }
}

plugins.withType(org.jetbrains.kotlin.gradle.targets.wasm.nodejs.WasmNodeJsRootPlugin::class) {
    extensions.configure(WasmNodeJsRootExtension::class.java) {
        configureNpmInstall(this)
    }
}