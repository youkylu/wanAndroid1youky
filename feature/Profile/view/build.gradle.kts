plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.AUTH_USECASE))
    implementation(projectDependency(Feature.PROFILE_USECASE))
    implementation(projectDependency(Lib.IMAGE_SERVICE_USECASE))
  
    implementation(Libs.AndroidX.Lifecycle.liveData)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.Lifecycle.viewModel)
    implementation(Libs.AndroidX.Lifecycle.extension)

    implementation(Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltCore)

    implementation(Libs.kotlin)

    kapt(Libs.Google.Dagger.hiltAndroidCompiler)
}
