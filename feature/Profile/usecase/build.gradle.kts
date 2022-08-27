plugins {
    id("kotlin-library-convention")
}

dependencies {
    implementation(projectDependency(Lib.CORE))

    implementation(Libs.kotlin)
    implementation(Libs.kotlinX)

    implementation(Libs.Google.Dagger.hiltCore)

    kapt(Libs.Google.Dagger.hiltAndroidCompiler)

}
