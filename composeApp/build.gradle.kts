import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
    alias(libs.plugins.android.application)
}

kotlin {
    androidTarget ()

    jvm()

    js {
        browser()
        binaries.executable()
    }

    wasmJs {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.materialKolor)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.activityCompose)
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }

        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

android {
    namespace = "com.github.terrakok"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        applicationId = "com.github.terrakok.androidApp"
        versionCode = 1
        versionName = "1.0.0"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.github.terrakok.desktopApp"
            packageVersion = "1.0.0"
        }
    }
}



fun configureNpmInstall(task: KotlinNpmInstallTask) {
    task.args += listOf("--network-concurrency", "1", "--mutex", "network")
}

rootProject.tasks.withType(KotlinNpmInstallTask::class.java).configureEach(::configureNpmInstall)

fun getOverriddenKotlinLanguageVersion(project: Project): KotlinVersion? {
    val languageVersion = project.rootProject.properties["community.project.kotlin.languageVersion"] as? String
        ?: project.rootProject.properties["kotlin_language_version"] as? String
    return languageVersion?.let {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin Language version: '$languageVersion' for project ${project.name}""")
        println("language version = $languageVersion")
        KotlinVersion.fromVersion(languageVersion)
    }
}

fun getOverriddenKotlinApiVersion(project: Project): KotlinVersion? {
    val apiVersion = project.rootProject.properties["community.project.kotlin.apiVersion"] as? String
        ?: project.rootProject.properties["kotlin_api_version"] as? String
    return apiVersion?.let {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin API version: '$apiVersion' for project $${project.name}""")
        println("api version = $apiVersion")
        KotlinVersion.fromVersion(apiVersion)
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        apiVersion.set(getOverriddenKotlinApiVersion(project) ?: KotlinVersion.KOTLIN_2_2)
        languageVersion.set(getOverriddenKotlinLanguageVersion(project) ?: KotlinVersion.KOTLIN_2_2)
    }
}
