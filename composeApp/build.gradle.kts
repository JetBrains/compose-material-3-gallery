import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
    alias(libs.plugins.android.application)
}

kotlin {
    @Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE", "OPT_IN_USAGE")
    compilerOptions {
        languageVersion.set(
            org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion(
                version = getOverriddenKotlinLanguageVersion(project) ?: "2.0"
            )
        )
        apiVersion.set(
            org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion(
                version = getOverriddenKotlinApiVersion(project) ?: "2.0"
            )
        )
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

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
    compileSdk = 34

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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
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

compose.experimental {
    web.application {}
}

fun getOverriddenKotlinLanguageVersion(project: Project): String? {
    val languageVersion = project.rootProject.properties["community.project.kotlin.languageVersion"] as? String
        ?: project.rootProject.properties["kotlin_language_version"] as? String
    if (languageVersion != null) {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin Language version: '$languageVersion' for project ${project.name}""")
    }
    return languageVersion
}

fun getOverriddenKotlinApiVersion(project: Project): String? {
    val apiVersion = project.rootProject.properties["community.project.kotlin.apiVersion"] as? String
        ?: project.rootProject.properties["kotlin_api_version"] as? String
    if (apiVersion != null) {
        project.logger.info("""[COMMUNITY_PROJECT_BUILD] Configured Kotlin API version: '$apiVersion' for project $${project.name}""")
    }
    return apiVersion
}

// Just a quicker way to force CI build k/wasm target too (which triggers just jsBrowserWebpack):
// https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/.teamcity/userprojects/external/ComposeMaterial3GalleryK2.kt
tasks.getByName("jsBrowserWebpack").dependsOn("jsBrowserDistribution")
tasks.getByName("jsBrowserDistribution").dependsOn("wasmJsBrowserDistribution")

// A workaround for https://youtrack.jetbrains.com/issue/KT-71675:
tasks.findByName("checkSandboxAndWriteProtection")?.dependsOn("syncComposeResourcesForIos")