plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.SEARCH_USECASE))
    implementation(Libs.Google.Dagger.hiltCore)
    implementation(Libs.kotlin)
    implementation(Libs.kotlinX)

    kapt(Libs.Google.Dagger.hiltCompiler)
}
