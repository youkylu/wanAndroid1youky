plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projectDependency(Lib.DATA_STORE_MANAGER_USECASE))
    implementation(Libs.AndroidX.DataStore.preferences)
}
