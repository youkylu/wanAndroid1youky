plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Feature.AUTH_USECASE))
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.Lifecycle.viewModel)
    implementation(Libs.AndroidX.Lifecycle.extension)
}
