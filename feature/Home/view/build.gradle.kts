plugins {
    id("android-library-convention")
}

dependencies {

    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltCore)

    implementation(Libs.kotlin)


    kapt(Libs.Google.Dagger.hiltCompiler)
}
