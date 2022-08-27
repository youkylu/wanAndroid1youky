plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Lib.IMAGE_SERVICE_USECASE))
    implementation(Libs.Glide.glide)
    kapt(Libs.Glide.compiler)
}
