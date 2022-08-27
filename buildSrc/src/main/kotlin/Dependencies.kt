import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Versions {
    const val kotlin = "1.7.0"
    const val kotlinX = "1.6.0"
    const val kotlinXSerialization = "1.3.2"
    const val ktxVersion = "1.8.0"

    const val material = "1.5.0"
    const val gson = "2.9.0"
    const val okhttp = "4.9.3"
    const val daggerHilt = "2.42"
    const val lifecycle = "2.4.1"
    const val navigation = "2.3.5"
    const val glide = "4.13.2"
    const val retrofit = "2.9.0"
    const val okhttpLoggingInterceptor = "4.10.0"
    const val persistentCookieJar = "v1.0.1"
    const val datastore = "1.0.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val kotlinX = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinX}"

    const val kotlinXSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinXSerialization}"

    const val junit = "org.junit.jupiter:junit-jupiter:5.8.2"

    const val kotest = "io.kotest:kotest-runner-junit5:5.3.2"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktxVersion}"
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.5"

        object Lifecycle {
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            const val extension = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        }

        object Navigation {
            const val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }

        object DataStore {
            const val preferences = "androidx.datastore:datastore-preferences:${Versions.datastore}"
        }
    }

    object Google {

        object Android {
            const val material = "com.google.android.material:material:1.4.0"
        }

        object Dagger {
            // Apache License 2.0 https://github.com/google/dagger/blob/master/LICENSE.txt
            const val dagger = "com.google.dagger:dagger:${Versions.daggerHilt}"
            const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
            const val hiltAndroidCompiler =
                "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
            const val hiltAndroidTesting =
                "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
            const val hiltCore = "com.google.dagger:hilt-core:${Versions.daggerHilt}"
            const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
        }
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Network{
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptor}"
        const val persistentCookieJar = "com.github.franmontiel:PersistentCookieJar:${Versions.persistentCookieJar}"
    }
}

fun DependencyHandler.projectDependency(project: Feature): ProjectDependency =
    project(":${project.projectName}")

fun DependencyHandler.projectDependency(project: Lib): ProjectDependency =
    project(":${project.projectName}")

enum class Feature(val projectName: String) {
    AUTH_DATA("AuthData"),
    AUTH_USECASE("AuthUsecase"),
    HOME_DATA("HomeData"),
    HOME_USECASE("HomeUsecase"),
    HOME_VIEW("HomeView"),
    PROFILE_DATA("ProfileData"),
    PROFILE_USECASE("ProfileUsecase"),
    PROFILE_VIEW("ProfileView"),
}

enum class Lib(val projectName: String) {
    CORE("Core"),
    DATA_STORE_MANAGER_DATA("DataStoreManagerData"),
    DATA_STORE_MANAGER_USECASE("DataStoreManagerUsecase"),
    IMAGE_SERVICE_DATA("ImageServiceData"),
    IMAGE_SERVICE_USECASE("ImageServiceUsecase"),
    NETWORK_DATA("NetworkData"),
    NETWORK_USECASE("NetworkUsecase"),
}