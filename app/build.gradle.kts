plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.grouma.dateontile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.grouma.dateontile"
        minSdk = 26
        targetSdk = 33
        versionCode = 4
        versionName = "1.2"

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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation("com.google.android.gms:play-services-wearable:18.1.0")
    // Use to implement support for wear tiles
    implementation("androidx.wear.tiles:tiles:1.3.0-beta01")

    // Use to utilize standard components and layouts in your tiles
    implementation("androidx.wear.protolayout:protolayout:1.1.0-beta01")

    // Use to utilize components and layouts with Material Design in your tiles
    implementation("androidx.wear.protolayout:protolayout-material:1.1.0-beta01")

    // Use to include dynamic expressions in your tiles
    implementation("androidx.wear.protolayout:protolayout-expression:1.1.0-beta01")
    implementation("androidx.wear.tiles:tiles-tooling-preview:1.3.0-beta01")
    implementation("androidx.compose.ui:ui-tooling-preview-android:1.5.4")

    // Use to preview wear tiles in your own app
    debugImplementation("androidx.wear.tiles:tiles-renderer:1.3.0-beta01")

    // Use to fetch tiles from a tile provider in your tests
    testImplementation("androidx.wear.tiles:tiles-testing:1.3.0-beta01")

    implementation("com.google.guava:guava:31.0.1-android")

    // To use CallbackToFutureAdapter
    implementation("androidx.concurrent:concurrent-futures:1.1.0")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.6.0")

    // Preview Tools
    implementation("com.google.android.horologist:horologist-compose-tools:0.4.8")
    implementation("com.google.android.horologist:horologist-tiles:0.4.8")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.google.android.horologist:horologist-compose-tools:0.4.8")
    implementation("com.google.android.horologist:horologist-tiles:0.4.8")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
}