plugins {
    id("kotlin-library-convention")
}

dependencies {

    implementation(Libs.Google.Dagger.hiltCore)
    implementation(Libs.kotlin)
    implementation(Libs.kotlinX)
    implementation(Libs.Network.retrofit)

    kapt(Libs.Google.Dagger.hiltCompiler)
}
