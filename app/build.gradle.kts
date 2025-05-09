plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.kapt")

    kotlin("plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.project.capstone"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.project.capstone"
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
        compose = true
    }
}

dependencies {

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:2.3.0")

    // Moshi
    implementation("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

    // Supabase
    implementation(platform("io.github.jan-tennert.supabase:bom:2.1.3"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:gotrue-kt")

    // Room Database
    implementation("androidx.room:room-runtime:2.7.0")
    kapt("androidx.room:room-compiler:2.7.0")

    // PDF Generation
    implementation("com.itextpdf:itext7-core:7.2.5")
    implementation("com.itextpdf:html2pdf:4.0.0")
    implementation("com.itextpdf:kernel:7.2.5")
    implementation("com.itextpdf:layout:7.2.5")

    // Hilt DI
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.9")

    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    // Kotlin coroutines untuk operasi asynchronous (I/O, background processing)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1")

    // Retrofit untuk HTTP request
    implementation("com.squareup.okhttp3:okhttp:3.4.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation("com.squareup.retrofit2:retrofit:2.1.0")

    // Gson untuk JSON parsing
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}