plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    libraryCommon(
        project = project,
        compose = true,
        stageBuildTypeEnabled = true,
        productFlavors = true
    )
    packagingOptions {
        resources.excludes.add("**/*.md")
    }
}

dependencies {

    implementation(Libs.AndroidX.Lifecycle.liveData)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.Lifecycle.viewModel)

    implementation(Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltAndroid)

    implementation(Libs.kotlin)

    kapt(Libs.Google.Dagger.hiltAndroidCompiler)

}
