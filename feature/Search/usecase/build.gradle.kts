plugins {
    id("kotlin-library-convention")
}

dependencies {
    implementation(projectDependency(Lib.CORE))
    implementation(Libs.Google.Dagger.hiltCore)
    implementation(Libs.kotlin)
    implementation(Libs.kotlinX)

    kapt(Libs.Google.Dagger.hiltCompiler)
}
