plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "1.8.0"
    id("kotlin-parcelize")

}


android {
    namespace = "com.example.poe_api_paumasia"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.poe_api_paumasia"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
//
//    implementation(libs.ktor.client.android)
//    implementation(libs.ktor.client.core)
//    implementation(libs.ktor.client.serialization)
//    implementation(libs.kotlinx.serialization.json)
//    implementation(libs.ktor.client.logging)

    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit)

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.8.7")

    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
}