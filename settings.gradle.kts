mapOf(
    "app" to "app",
    "AuthData" to "feature/Auth/data",
    "AuthUsecase" to "feature/Auth/usecase",
    "Core" to "libs/Core",
    "DataStoreManagerData" to "libs/DataStoreManager/data",
    "DataStoreManagerUsecase" to "libs/DataStoreManager/usecase",
    "HomeData" to "feature/Home/data",
    "HomeUsecase" to "feature/Home/usecase",
    "HomeView" to "feature/Home/view",
    "ImageServiceData" to "libs/ImageService/data",
    "ImageServiceUsecase" to "libs/ImageService/usecase",
    "NetworkData" to "libs/Network/data",
    "NetworkUsecase" to "libs/Network/usecase",
    "ProfileData" to "feature/Profile/data",
    "ProfileUsecase" to "feature/Profile/usecase",
    "ProfileView" to "feature/Profile/view",
).forEach{ (projectName, projectPath)->
    include(":$projectName")
    project(":$projectName").projectDir = File(projectPath)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform") version "1.6.10"
        id("com.android.library") version "7.2.1"
        id("org.jetbrains.kotlin.android") version "1.7.10"
    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//
//}
rootProject.name = "wanAndroidyouky1"


