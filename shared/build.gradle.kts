@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    jvm()

    wasmJs {
        browser()
    }

    js {
        browser()
    }

    listOf(
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
                implementation(libs.runtime)
                implementation(libs.ui)
                implementation(libs.compose.material3)
                implementation(libs.material.icons)
                implementation(libs.resources)
                implementation(libs.ui.tooling.preview)
                implementation(libs.materialKolor)
                implementation(libs.kotlinx.coroutines)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
    }

    android {
        namespace = "com.github.terrakok"
        compileSdk = 37
        minSdk = 24
        androidResources { enable = true }
    }
}
