plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.PROFILE_USECASE))

    implementation(projectDependency(Lib.NETWORK_USECASE))
    implementation(Libs.Network.retrofit)

}
