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
    }
    kotlinOptions{
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
//    implementation 'androidx.core:core-ktx:1.8.0'
//    implementation ("androidx.appcompat:appcompat:1.3.0")
//    implementation ("com.google.android.material:material:1.4.0")
    implementation (Libs.AndroidX.coreKtx)
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.Android.material)
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
//    kapt(Libs.Google.Dagger.hiltAndroidCompiler)
}