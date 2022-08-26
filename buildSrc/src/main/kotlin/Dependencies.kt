
object Versions{
    const val kotlin = "1.7.0"
    const val kotlinX = "1.6.0"
    const val kotlinXSerialization = "1.3.2"
    const val ktxVersion = "1.8.0"

    const val material = "1.5.0"
    const val gson = "2.9.0"
    const val okhttp = "4.9.3"
    const val daggerHilt = "2.42"

}

object Libs{
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val kotlinX = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinX}"

    const val kotlinXSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinXSerialization}"

    const val junit = "org.junit.jupiter:junit-jupiter:5.8.2"

    const val kotest = "io.kotest:kotest-runner-junit5:5.3.2"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktxVersion}"
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
    }

    object  Android{
        const val material = "com.google.android.material:material:1.4.0"
    }
    object Google{
        object Dagger {
            // Apache License 2.0 https://github.com/google/dagger/blob/master/LICENSE.txt
            const val dagger = "com.google.dagger:dagger:${Versions.daggerHilt}"
            const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
            const val hiltAndroidCompiler =
                "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
            const val hiltAndroidTesting =
                "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
            const val hiltCore = "com.google.dagger:hilt-core:${Versions.daggerHilt}"
            const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
        }
    }



}