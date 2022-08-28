plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.AUTH_USECASE))
    implementation(projectDependency(Lib.NETWORK_USECASE))
    implementation(projectDependency(Lib.DATA_STORE_MANAGER_USECASE))
    implementation(Libs.Network.retrofit)

}
