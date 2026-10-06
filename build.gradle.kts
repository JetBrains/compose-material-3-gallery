import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.kotlinJvm).apply(false)
    alias(libs.plugins.composeMultiplatform).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.kotlin.multiplatform.library).apply(false)
    alias(libs.plugins.composeCompiler).apply(false)
    id("com.github.ben-manes.versions").version("0.51.0")
}


tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

fun configureNpmInstall(task: KotlinNpmInstallTask) {
    task.args += listOf("--network-concurrency", "1", "--mutex", "network")
}

rootProject.tasks.withType(KotlinNpmInstallTask::class.java).configureEach(::configureNpmInstall)

fun getOverriddenKotlinLanguageVersion(project: Project): String? {
    val languageVersion = (project.rootProject.properties["kotlin_language_version"]
        ?: project.rootProject.properties["kotlin.language.version"]
        ?: project.rootProject.properties["kotlin.languageVersion"]) as? String
    if (languageVersion != null) {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin Language version: '$languageVersion' for project ${project.name}""")
    }
    return languageVersion
}

fun getOverriddenKotlinApiVersion(project: Project): String? {
    val apiVersion = (project.rootProject.properties["kotlin_api_version"]
        ?: project.rootProject.properties["kotlin.api.version"]
        ?: project.rootProject.properties["kotlin.apiVersion"]) as? String
    if (apiVersion != null) {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin API version: '$apiVersion' for project ${project.name}""")
    }
    return apiVersion
}

val kotlinAdditionalCliOptions = providers.gradleProperty("kotlin_additional_cli_options")
    .map { if (it.isNotBlank()) it.split(" ") else emptyList() }
    .orNull

subprojects {
    tasks.withType<KotlinCompilationTask<*>>().configureEach kotlinCompilationTask@{
        @Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE", "OPT_IN_USAGE")
        compilerOptions {
            getOverriddenKotlinLanguageVersion(project)?.let {
                languageVersion.set(KotlinVersion.fromVersion(it))
            }
            getOverriddenKotlinApiVersion(project)?.let {
                apiVersion.set(KotlinVersion.fromVersion(it))
            }

            freeCompilerArgs.addAll(
                "-Xreport-all-warnings",
                "-Xrender-internal-diagnostic-names"
            )

            if (kotlinAdditionalCliOptions != null) {
                freeCompilerArgs.addAll(kotlinAdditionalCliOptions)
                logger.info("[COMMUNITY_PROJECT_BUILD] ${this@kotlinCompilationTask.path}: added ${kotlinAdditionalCliOptions.joinToString(" ")}")
            }

            allWarningsAsErrors.set(false)
            freeCompilerArgs.set(freeCompilerArgs.getOrElse(emptyList()).filterNot { it == "-Werror" })

            logger.info("[COMMUNITY_PROJECT_BUILD] ${this@kotlinCompilationTask.path}: disabled -Werror")
        }
    }
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
        maven("https://packages.jetbrains.team/maven/p/cmp/dev")
        maven("https://androidx.dev/storage/compose-compiler/repository/")
        (kotlinRepoDot ?: kotlin_repo_url)?.takeIf { it.isNotBlank() }?.let { maven(it) }
        composeCompilerCustomRepo?.takeIf { it.isNotBlank() }?.let { maven(it) }
        maven("https://packages.jetbrains.team/maven/p/kt/dev/")
    }
}
