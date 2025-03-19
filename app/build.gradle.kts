plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.newsinshort"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsinshort"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidxJunit)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.composeUiTestJunit4)

    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)

    implementation(project(Modules.utilities))

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
}

kapt {
    correctErrorTypes = true
}