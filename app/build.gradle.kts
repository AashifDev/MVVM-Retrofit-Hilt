plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.mvvmretrofithilt"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mvvmretrofithilt"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")

    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")
    //implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
    //kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha01")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    //implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // Networking
    implementation ("com.squareup.retrofit2:converter-moshi:2.6.2")
    implementation ("com.squareup.retrofit2:retrofit:2.8.1")
    implementation ("com.squareup.okhttp3:okhttp:4.7.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.7.2")

    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6")
}