pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform") version "1.6.10"

        id("com.android.library") version "7.2.2"
        id("org.jetbrains.kotlin.android") version "1.6.10"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
//    versionCatalogs {
//        create("")
//    }
}
rootProject.name = "wanAndroidyouky1"
include(":app")

