plugins {
    id("android-library-convention")
}

dependencies {
    implementation(Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltCore)
    implementation(Libs.kotlin)
    implementation(Libs.kotlinX)

    kapt(Libs.Google.Dagger.hiltCompiler)
}
