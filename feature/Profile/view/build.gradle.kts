plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.PROFILE_USECASE))
    implementation(projectDependency(Lib.IMAGE_SERVICE_USECASE))
  
    implementation(Libs.AndroidX.Lifecycle.liveData)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.fragmentKtx)

    implementation(Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltAndroid)

    implementation(Libs.kotlin)

    kapt(Libs.Google.Dagger.hiltAndroidCompiler)
}
