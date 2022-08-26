plugins {
    `kotlin-dsl`

}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
//    implementation("com.google.dagger:hilt-android-gradle-plugin:2.43.2")

//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    val kotestVersion = "5.3.2"
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.mockk:mockk:1.12.3")
}
