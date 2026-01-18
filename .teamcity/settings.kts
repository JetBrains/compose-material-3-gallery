import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.XmlReport
import jetbrains.buildServer.configs.kotlin.buildFeatures.dockerRegistryConnections
import jetbrains.buildServer.configs.kotlin.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildFeatures.xmlReport
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.kotlinFile
import jetbrains.buildServer.configs.kotlin.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"

project {
    description = "ComposeMaterial3Gallery projects with the target compose version"

    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopMacOS)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopWindows)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryIOS)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopWindows)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmMobile)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopLinux)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_AndroidApkOnlyComposeMaterial3gallery)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_AggregateComposeMaterial3Gallery)
    buildType(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopMacOS)
}

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_AggregateComposeMaterial3Gallery : BuildType({
    id("2_AggregateComposeMaterial3Gallery")
    name = "[Aggregate] ComposeMaterial3Gallery"
    description = "Aggregate build of ComposeMaterial3Gallery projects with the target compose version"

    type = BuildTypeSettings.Type.COMPOSITE
    buildNumberPattern = "${Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopMacOS.depParamRefs["compose.version"]} (%build.counter%)"

    params {
        text("reverse.dep.*.kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("reverse.dep.*.compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        text("reverse.dep.*.compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("reverse.dep.*.savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.internal.vcsTrigger.branchMaxChangeAge", "30")
        text("reverse.dep.*.navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    dependencies {
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_AndroidApkOnlyComposeMaterial3gallery) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopLinux) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopMacOS) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopWindows) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryIOS) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopMacOS) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopWindows) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
        dependency(Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmMobile) {
            snapshot {
            }

            artifacts {
                artifactRules = "+:*"
            }
        }
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_AndroidApkOnlyComposeMaterial3gallery : BuildType({
    id("2_AndroidApkOnlyComposeMaterial3gallery")
    name = "🍏ᵐ [Android][APK Only] Compose material 3 gallery"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryAndroid.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = "+:compose-material-3-gallery/composeApp/build/outputs/apk/debug/*.apk => %compose.version%-compose_material3_gallery-android-debug.zip"
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.ANDROID_HOME", "%env.HOME%/Library/Android/sdk")
        param("teamcity.activeVcsBranch.age.days", "30")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        param("env.GRADLE_USER_HOME", "%teamcity.agent.home.dir%/system/gradle")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Assemble Android debug APK"
            tasks = ":composeApp:assembleDebug"
            workingDir = "compose-material-3-gallery"
            gradleParams = " --stacktrace --info --continue --init-script %teamcity.build.checkoutDir%/community-project-plugin/cache-redirector.init.gradle"
        }
    }

    failureConditions {
        executionTimeoutMin = 30
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        contains("system.cloud.profile_id", "rigel-up-k8s")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopLinux : BuildType({
    id("2_TestComposeMaterial3GalleryDesktopLinux")
    name = "🐧 [Test] Compose Material3 Gallery | Desktop Linux"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryDesktopTestLinux.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery  => desktop-dist-linux.zip
        +:compose-ui-tests/launch-tests/build/reports/tests/test => test-report.zip => test-report.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.internal.docker.autoLogin.registries", "PROJECT_EXT_6,PROJECT_EXT_3")
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("docker.image", "registry.jetbrains.team/p/kct/containers/jdk-17-native-amd64:latest")
        param("teamcity.activeVcsBranch.age.days", "30")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "build linux artifact"
            tasks = ":composeApp:createDistributable"
            workingDir = "compose-material-3-gallery"
            gradleParams = " --stacktrace --info --continue --init-script %teamcity.build.checkoutDir%/community-project-plugin/cache-redirector.init.gradle"
            dockerImage = "%docker.image%"
        }
        script {
            name = "Copy Desktop dist to root"
            scriptContent = """
                mkdir -p .
                cp -R compose-material-3-gallery/composeApp/build/compose/binaries/main/app/* ./
            """.trimIndent()
        }
        gradle {
            name = "Run Desktop test"
            tasks = """test --tests "*Material3DesktopTest""""
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        dockerRegistryConnections {
            loginToRegistry = on {
                dockerRegistryId = "PROJECT_EXT_3"
            }
        }
        xmlReport {
            reportType = XmlReport.XmlReportType.JUNIT
            rules = "compose-ui-tests/launch-tests/build/test-results/test"
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Linux")
        contains("system.cloud.profile_id", "rigel-up-aws")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopMacOS : BuildType({
    id("2_TestComposeMaterial3GalleryDesktopMacOS")
    name = "🍏ᵐ [Test] Compose Material3 Gallery | Desktop macOS"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryDesktopTestMac.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery => desktop-dist-mac.zip
        +:compose-ui-tests/launch-tests/build/reports/tests/test => test-report.zip => test-report
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        param("env.JAVA_HOME", "%env.JDK_17_0%")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        param("env.GRADLE_USER_HOME", "%teamcity.agent.home.dir%/system/gradle")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Build Desktop distribution"
            tasks = ":composeApp:packageDmg"
            workingDir = "compose-material-3-gallery"
        }
        script {
            name = "Copy Desktop dist to root"
            scriptContent = """
                mkdir -p .
                cp -R compose-material-3-gallery/composeApp/build/compose/binaries/main/app/* ./
            """.trimIndent()
        }
        gradle {
            name = "Run Desktop test"
            tasks = """test --tests "*Material3DesktopTest""""
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        xmlReport {
            reportType = XmlReport.XmlReportType.JUNIT
            rules = "compose-ui-tests/launch-tests/build/test-results/test"
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        contains("system.cloud.profile_id", "rigel-up-k8s")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryDesktopWindows : BuildType({
    id("2_TestComposeMaterial3GalleryDesktopWindows")
    name = "🪟 [Test] Compose Material3 Gallery | Desktop Windows"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryDesktopTestWindows.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery => desktop-dist-windows.zip
        +:compose-ui-tests/launch-tests/build/reports/tests/test => test-report.zip => test-report.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        param("env.JAVA_HOME", "%env.JDK_17_0%")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Build Desktop distribution"
            tasks = ":composeApp:createDistributable"
            workingDir = "compose-material-3-gallery"
        }
        powerShell {
            name = "Copy Desktop dist to root (Windows)"
            scriptMode = script {
                content = """
                    New-Item -ItemType Directory -Path . -Force | Out-Null
                    Copy-Item -Path "compose-material-3-gallery\\composeApp\\build\\compose\\binaries\\main\\app\\*" -Destination . -Recurse -Force
                """.trimIndent()
            }
        }
        gradle {
            name = "Run Desktop test"
            tasks = """test --tests "*Material3DesktopTest""""
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        xmlReport {
            reportType = XmlReport.XmlReportType.JUNIT
            rules = "compose-ui-tests/launch-tests/build/test-results/test"
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Windows")
        contains("system.cloud.profile_id", "rigel-up-aws")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryIOS : BuildType({
    id("2_TestComposeMaterial3GalleryIOS")
    name = "🍏ᵐ [Test] Compose Material3 Gallery | iOS"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryIosTest.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery  => Material 3 Gallery.zip
        +:compose-ui-tests/launch-tests/build/reports/tests/test => test-report.zip => test-report.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        param("env.GRADLE_USER_HOME", "%teamcity.agent.home.dir%/system/gradle")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        script {
            name = "Build iOS App for Simulators"
            workingDir = "compose-material-3-gallery"
            scriptContent = """
                cd iosApp
                xcodebuild \
                    -project iosApp.xcodeproj \
                    -scheme iosApp \
                    -sdk iphonesimulator \
                    -configuration Debug \
                    -derivedDataPath artifacts \
                     \
                    build
            """.trimIndent()
        }
        script {
            name = "Prepare iOS App for Devices: Install Apple Certificates in Custom Keychain"
            workingDir = "compose-material-3-gallery"
            scriptContent = """
                echo "Creating custom keychain..."
                
                security create-keychain -p 123456 custom.keychain-db || {
                    echo "Failed to create custom keychain!" >&2
                    exit 1
                }
                
                echo "Importing Apple Worldwide Developer Relations Certification Authority..."
                
                security import ./Apple\ Worldwide\ Developer\ Relations\ Certification\ Authority.cer -k ~/Library/Keychains/custom.keychain-db -T /usr/bin/codesign || {
                    echo "Failed to import Apple Worldwide Developer Relations Certification Authority.cer to custom keychain!" >&2
                    exit 1
                }
                
                echo "Importing main signing certificate..."
                
                security import ./cert3.p12 -k ~/Library/Keychains/custom.keychain-db -P 123456 -T /usr/bin/codesign || {
                    echo "Failed to import cert3.p12 to custom keychain!" >&2
                    exit 1
                }
                
                echo "Setting keychain permissions..."
                
                security set-key-partition-list -S apple-tool:,apple: -s -k 123456 ~/Library/Keychains/custom.keychain-db || {
                    echo "Failed to set keychain permissions!" >&2
                    exit 1
                }
                
                echo "Unlocking custom keychain..."
                security unlock-keychain -p 123456 ~/Library/Keychains/custom.keychain-db
                
                echo "Setting custom keychain as default and adjusting timeout..."
                security set-keychain-settings -lut 6000 ~/Library/Keychains/custom.keychain-db
                security list-keychains -d user -s ~/Library/Keychains/custom.keychain-db
                security default-keychain -d user -s ~/Library/Keychains/custom.keychain-db
                
                echo "Checking valid signing identities after import..."
                security find-identity -p codesigning -v ~/Library/Keychains/custom.keychain-db
                security find-identity -p codesigning -v ~/Library/Keychains/custom.keychain-db | grep "valid identities found" | grep -q "0 valid identities" && {
                    echo "No valid signing identities found in custom keychain!" >&2
                    exit 1
                }
                
                echo "Certificates imported, permissions set, and custom keychain unlocked successfully."
            """.trimIndent()
        }
        script {
            name = "Prepare iOS App for Devices:Copy Provisioning Profile to MobileDevice Directory"
            workingDir = "compose-material-3-gallery"
            scriptContent = """
                echo "Copying provisioning profile to MobileDevice directory..."
                mkdir -p ~/Library/MobileDevice/Provisioning\ Profiles
                cp ./Profile.mobileprovision ~/Library/MobileDevice/Provisioning\ Profiles/493730d6-0dcc-4065-b77d-e926f4a32753.mobileprovision
                [ -f ~/Library/MobileDevice/Provisioning\ Profiles/493730d6-0dcc-4065-b77d-e926f4a32753.mobileprovision ] || {
                    echo "Failed to copy provisioning profile." >&2
                    exit 1
                }
                echo "Provisioning profile copied successfully."
            """.trimIndent()
        }
        script {
            name = "Prepare iOS App for Devices:Verify Provisioning Profile Presence"
            workingDir = "compose-material-3-gallery"
            scriptContent = """
                echo "Verifying provisioning profile presence..."
                if xcrun security cms -D -i ~/Library/MobileDevice/Provisioning\ Profiles/493730d6-0dcc-4065-b77d-e926f4a32753.mobileprovision > /dev/null 2>&1; then
                    echo "Provisioning profile found successfully."
                else
                    echo "Provisioning profile not found!" >&2
                    exit 1
                fi
            """.trimIndent()
        }
        script {
            name = "Prepare iOS App for Devices: Build iOS Application"
            workingDir = "compose-material-3-gallery"
            scriptContent = """
                echo "Starting iOS app build..."
                cd iosApp
                security list-keychains -d user -s ~/Library/Keychains/custom.keychain-db
                
                xcodebuild \
                    -project iosApp.xcodeproj \
                    -scheme iosApp \
                    -sdk iphoneos \
                    -configuration Debug \
                    -derivedDataPath ../artifacts/ \
                    DEVELOPMENT_TEAM="4FY685D7XA" \
                    PROVISIONING_PROFILE="eb521e5e-abb2-47cf-a03d-32aef8dc92e0" \
                    CODE_SIGN_STYLE="Manual" \
                    OTHER_CODE_SIGN_FLAGS="--keychain ~/Library/Keychains/custom.keychain-db --verbose"
                
                echo "iOS app build completed successfully."
            """.trimIndent()
        }
        script {
            name = "Copy Material 3 gallery.app to root"
            scriptContent = """
                mkdir -p .
                cp -R "compose-material-3-gallery/iosApp/artifacts/Build/Products/Debug-iphonesimulator/Material 3 gallery.app" "./Material 3 gallery.app"
            """.trimIndent()
        }
        gradle {
            name = "Run iOS test"
            tasks = """test --tests "*Material3IosTest""""
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        xmlReport {
            reportType = XmlReport.XmlReportType.JUNIT
            rules = "compose-ui-tests/launch-tests/build/test-results/test"
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        contains("system.cloud.profile_id", "rigel-up-k8s")
        noLessThanVer("tools.xcode.version", "15.0")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopMacOS : BuildType({
    id("2_TestComposeMaterial3GalleryWasmDesktopMacOS")
    name = "🍏ᵐ [Test] Compose Material3 Gallery | WASM | Desktop macOS"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryWasmBrowserTestMacOS.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery => wasm-dist.zip
        +:compose-ui-tests => tests-core.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        param("env.JAVA_HOME", "%env.JDK_17_0%")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        param("env.GRADLE_USER_HOME", "%teamcity.agent.home.dir%/system/gradle")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        script {
            name = "Enable Safari remote automation"
            scriptContent = """
                echo "Enabling Safari remote automation..."
                sudo -S safaridriver --enable <<< "jetbrains"
                defaults write com.apple.Safari AllowRemoteAutomation -bool true
                killall Safari || true
            """.trimIndent()
        }
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Upgrade Yarn lock and build WASM distribution"
            tasks = "kotlinUpgradeYarnLock :composeApp:wasmJsBrowserDistribution"
            workingDir = "compose-material-3-gallery"
            gradleParams = " --stacktrace --info --continue --init-script %teamcity.build.checkoutDir%/community-project-plugin/cache-redirector.init.gradle"
        }
        script {
            name = "Copy WASM artifacts to root"
            scriptContent = """
                mkdir -p ./wasm-dist
                if [ -d "compose-material-3-gallery/compose-web/build/dist" ]; then
                  cp -R compose-material-3-gallery/compose-web/build/dist/* ./wasm-dist/
                elif [ -d "compose-material-3-gallery/composeApp/build/dist" ]; then
                  cp -R compose-material-3-gallery/composeApp/build/dist/* ./wasm-dist/
                else
                  echo "❌ No dist directory found"
                  exit 1
                fi
            """.trimIndent()
        }
        gradle {
            name = "Run WASM test"
            tasks = "test --tests test.material3.Material3WasmTest --tests test.material3.Material3CompatibilityWasmTest -PincludeTags=desktop"
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:*"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        contains("system.cloud.profile_id", "rigel-up-k8s")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmDesktopWindows : BuildType({
    id("2_TestComposeMaterial3GalleryWasmDesktopWindows")
    name = "🪟 [Test] Compose Material3 Gallery | WASM | Desktop Windows"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryWasmBrowserTestWindows.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery => wasm-dist.zip
        +:compose-ui-tests => tests-core.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        param("env.JAVA_HOME", "%env.JDK_17_0%")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Upgrade Yarn lock and build WASM distribution"
            tasks = "kotlinUpgradeYarnLock :composeApp:wasmJsBrowserDistribution"
            workingDir = "compose-material-3-gallery"
            gradleParams = " --stacktrace --info --continue --init-script %teamcity.build.checkoutDir%/community-project-plugin/cache-redirector.init.gradle"
        }
        powerShell {
            name = "Copy WASM artifacts to root (Windows)"
            scriptMode = script {
                content = """
                    # Create output directory
                    New-Item -ItemType Directory -Path "wasm-dist" -Force | Out-Null
                    
                    ${'$'}composeWeb = Join-Path "compose-material-3-gallery" "compose-web/build/dist"
                    ${'$'}composeApp = Join-Path "compose-material-3-gallery" "composeApp/build/dist"
                    
                    if (Test-Path ${'$'}composeWeb) {
                        Copy-Item -Path "${'$'}composeWeb\*" -Destination "wasm-dist" -Recurse -Force
                    }
                    elseif (Test-Path ${'$'}composeApp) {
                        Copy-Item -Path "${'$'}composeApp\*" -Destination "wasm-dist" -Recurse -Force
                    }
                    else {
                        Write-Host "❌ No dist directory found"
                        exit 1
                    }
                """.trimIndent()
            }
        }
        gradle {
            name = "Run WASM test"
            tasks = "test --tests test.material3.Material3WasmTest -PincludeTags=desktop"
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Windows")
        contains("system.cloud.profile_id", "rigel-up-aws")
    }
})

object Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeProjects_ComposeMaterial3Gallery_2_TestComposeMaterial3GalleryWasmMobile : BuildType({
    id("2_TestComposeMaterial3GalleryWasmMobile")
    name = "🍎 [Test] Compose Material3 Gallery | WASM | Mobile"
    description = """
        TC configuration [file](https://jetbrains.team/p/kti/repositories/kotlin-teamcity-build/files/master/.teamcity/userprojects/compose/material3Gallery/ComposeMaterial3GalleryWasmBrowserTestMobile.kt). User Projects [Knowledge Base](https://youtrack.jetbrains.com/articles/KT-A-522/User-Projects)
        Repositories used: [compose.material3.gallery](https://jetbrains.team/p/kct/repositories/compose-material-3-gallery-kct/files/compose-integration) (branch: compose-integration); [compose-ui-tests](https://jetbrains.team/p/compose-qa/repositories/compose-ui-tests/files/KQA-2310) (branch: KQA-2310); [compose-multiplatform-core (GitHub)](https://github.com/JetBrains/compose-multiplatform/tree/null) (branch: null)
    """.trimIndent()

    artifactRules = """
        +:compose-material-3-gallery => wasm-dist.zip
        +:compose-ui-tests => tests-core.zip
    """.trimIndent()
    buildNumberPattern = "%compose.version% (%build.counter%)"

    params {
        text("compose.material.navigation.version", "", description = "compose material navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.version", "", description = "compose material3 version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("navigation.version", "", description = "navigation version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeBuildBranch.age.hours", "72")
        text("compose.version", "", description = "compose version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("kotlin.version", "", description = "kotlin version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("compose.material3.adaptive.version", "", description = "compose material3 adaptive version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("teamcity.activeVcsBranch.age.days", "30")
        param("env.JAVA_HOME", "%env.JDK_17_0%")
        text("graphics.shapes.version", "", description = "graphics shapes version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("window.version", "", description = "window version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("lifecycle.version", "", description = "lifecycle version", display = ParameterDisplay.PROMPT, allowEmpty = true)
        param("env.TEAMCITY_BUILD_CHECKOUT_DIR", "%teamcity.build.checkoutDir%")
        param("env.VERSIONS_FILE", "compose-material-3-gallery/gradle/libs.versions.toml")
        param("env.GRADLE_USER_HOME", "%teamcity.agent.home.dir%/system/gradle")
        text("savedstate.version", "", description = "savedstate version", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => compose-material-3-gallery")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeUiTestsVcs"), "+:. => compose-ui-tests")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_CommunityProjectPluginVcs"), "+:. => community-project-plugin")
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_ComposeCoreVcs"))
        root(AbsoluteId("Kotlin_KotlinCloud_BuildPlayground_Rigel_KotlinAutomationScriptsVcs"), "+:. => kotlin-qa-tc-scripts")
    }

    steps {
        script {
            name = "Enable Safari remote automation"
            scriptContent = """
                echo "Enabling Safari remote automation..."
                sudo -S safaridriver --enable <<< "jetbrains"
                defaults write com.apple.Safari AllowRemoteAutomation -bool true
                killall Safari || true
            """.trimIndent()
        }
        kotlinFile {
            name = "[Versions] Resolve and update (Kotlin, external script)"
            path = "./kotlin-qa-tc-scripts/src/update-versions-compose.main.kts"
            compiler = "%teamcity.tool.kotlin.compiler.bundled%"
            jdkHome = "%env.JDK_17_0%"
        }
        gradle {
            name = "Upgrade Yarn lock and build WASM distribution"
            tasks = "kotlinUpgradeYarnLock :composeApp:wasmJsBrowserDistribution"
            workingDir = "compose-material-3-gallery"
            gradleParams = " --stacktrace --info --continue --init-script %teamcity.build.checkoutDir%/community-project-plugin/cache-redirector.init.gradle"
        }
        script {
            name = "Copy WASM artifacts to root"
            scriptContent = """
                mkdir -p ./wasm-dist
                if [ -d "compose-material-3-gallery/compose-web/build/dist" ]; then
                  cp -R compose-material-3-gallery/compose-web/build/dist/* ./wasm-dist/
                elif [ -d "compose-material-3-gallery/composeApp/build/dist" ]; then
                  cp -R compose-material-3-gallery/composeApp/build/dist/* ./wasm-dist/
                else
                  echo "❌ No dist directory found"
                  exit 1
                fi
            """.trimIndent()
        }
        gradle {
            name = "Run WASM test"
            tasks = "test --tests test.material3.Material3WasmTest --tests test.material3.Material3CompatibilityWasmTest -PincludeTags=mobile"
            workingDir = "compose-ui-tests/launch-tests"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            firstFailureAfterSuccess = true
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_7"
                sendTo = "#compose-multiplatform-autotests"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            buildFailedToStart = true
            firstFailureAfterSuccess = true
            firstSuccessAfterFailure = true
        }
        perfmon {
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        matches("teamcity.agent.name", "compose-metal-.*")
    }
})
