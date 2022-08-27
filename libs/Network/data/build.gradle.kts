plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Lib.NETWORK_USECASE))
    implementation(Libs.Network.converterGson)
    implementation(Libs.Network.okhttpLoggingInterceptor)
    implementation(Libs.Network.retrofit)
}
