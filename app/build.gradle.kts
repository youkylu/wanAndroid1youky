plugins {
    id("android-application-convention")
}

android {
    compileSdk  = 32

    defaultConfig {
        applicationId = "com.example.wanandroidyouky1"
        minSdk =23
        targetSdk =32
        versionCode =1
        versionName ="1.0"
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

        kotlin{
            kotlinOptions{
                freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }
    kotlinOptions{
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //modules
    implementation(projectDependency(Feature.AUTH_DATA))
    implementation(projectDependency(Feature.AUTH_USECASE))
    implementation(projectDependency(Feature.AUTH_VIEW))
    implementation(projectDependency(Feature.HOME_DATA))
    implementation(projectDependency(Feature.HOME_USECASE))
    implementation(projectDependency(Feature.HOME_VIEW))
    implementation(projectDependency(Feature.PROFILE_DATA))
    implementation(projectDependency(Feature.PROFILE_USECASE))
    implementation(projectDependency(Feature.PROFILE_VIEW))
    implementation(projectDependency(Feature.SEARCH_DATA))
    implementation(projectDependency(Feature.SEARCH_USECASE))
    implementation(projectDependency(Feature.SEARCH_VIEW))
    implementation(projectDependency(Lib.CORE))
    implementation(projectDependency(Lib.DATA_STORE_MANAGER_DATA))
    implementation(projectDependency(Lib.DATA_STORE_MANAGER_USECASE))
    implementation(projectDependency(Lib.IMAGE_SERVICE_DATA))
    implementation(projectDependency(Lib.IMAGE_SERVICE_USECASE))
    implementation(projectDependency(Lib.NETWORK_DATA))
    implementation(projectDependency(Lib.NETWORK_USECASE))

    //android libs
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.AndroidX.coreKtx)
    implementation (Libs.AndroidX.Navigation.fragmentKtx)
    implementation (Libs.AndroidX.Navigation.uiKtx)
    implementation (Libs.Google.Android.material)
    implementation(Libs.Google.Dagger.hiltAndroid)

    kapt(Libs.Google.Dagger.hiltAndroidCompiler)

    //test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

}