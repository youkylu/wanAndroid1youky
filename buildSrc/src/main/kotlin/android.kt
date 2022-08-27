import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.utils.KOTLIN_KAPT_PLUGIN_ID
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("UnstableApiUsage")
fun CommonExtension<*, *, *, *>.androidCommon(
    project: Project,
    compose: Boolean = false,
    stageBuildTypeEnabled: Boolean = false,
    productFlavors: Boolean = false,
) {
    compileSdk = 32
    defaultConfig {
        minSdk = 23

        vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    project.tasks.withType(KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName(BuildType.DEBUG.buildTypeName) {
            isTestCoverageEnabled = true
        }
        getByName(BuildType.RELEASE.buildTypeName) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    testOptions {
        animationsDisabled = true
        unitTests.isReturnDefaultValues = true
    }

    project.tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
            events = setOf(
                TestLogEvent.STARTED,
                TestLogEvent.SKIPPED,
                TestLogEvent.PASSED,
                TestLogEvent.FAILED,
                TestLogEvent.STANDARD_ERROR
            )
            showStandardStreams = true
        }
    }


    lint {
        abortOnError = true
        ignoreTestFixturesSources = true
        lintConfig = project.rootProject.file("lint.xml")
        warningsAsErrors = true
    }

    if (project.isKotlinKaptPluginApplied) {
        project.kapt {
            correctErrorTypes = true
            useBuildCache = true
            javacOptions {
                option("-Xmaxerrs", 500)
            }
        }
    }
}

@Suppress("UnstableApiUsage")
fun LibraryExtension.libraryCommon(
    project: Project,
    compose: Boolean = false,
    stageBuildTypeEnabled: Boolean = false,
    productFlavors: Boolean = false,
) {
    androidCommon(
        project = project,
        compose = compose,
        stageBuildTypeEnabled = stageBuildTypeEnabled,
        productFlavors = productFlavors
    )
    defaultConfig {
        targetSdk = 32
    }
}

private val Project.isKotlinKaptPluginApplied: Boolean
    get() = pluginManager.hasPlugin(KOTLIN_KAPT_PLUGIN_ID)

private fun Project.kapt(configure: Action<KaptExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("kapt", configure)

enum class BuildType(val buildTypeName: String) {
    DEBUG(
        "debug" // must be this value. do NOT change
    ),
    RELEASE(
        "release" // must be this value. do NOT change
    ),
    STAGE(
        "stage"
    )
}
