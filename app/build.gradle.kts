plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.grouma.dateontile"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.grouma.dateontile"
        minSdk = 26
        targetSdk = 34
        versionCode = 6
        versionName = "1.4"

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

    implementation("com.google.android.gms:play-services-wearable:19.0.0")
    // Use to implement support for wear tiles
    implementation("androidx.wear.tiles:tiles:1.5.0")

    // Use to utilize standard components and layouts in your tiles
    implementation("androidx.wear.protolayout:protolayout:1.3.0")

    // Use to utilize components and layouts with Material Design in your tiles
    implementation("androidx.wear.protolayout:protolayout-material:1.3.0")
    implementation("androidx.wear.protolayout:protolayout-material3:1.3.0")

    // Use to include dynamic expressions in your tiles
    implementation("androidx.wear.protolayout:protolayout-expression:1.3.0")

    // Use to preview wear tiles in your own app
    debugImplementation("androidx.wear.tiles:tiles-renderer:1.5.0")

    // Use to fetch tiles from a tile provider in your tests
    testImplementation("androidx.wear.tiles:tiles-testing:1.5.0")

    // Use to include dynamic expressions in your tiles
    implementation("androidx.wear.protolayout:protolayout-expression:1.3.0")
    implementation("androidx.wear.tiles:tiles-tooling-preview:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview-android:1.9.2")

    // Use to preview wear tiles in your own app
    debugImplementation("androidx.wear.tiles:tiles-renderer:1.5.0")

    // Use to fetch tiles from a tile provider in your tests
    testImplementation("androidx.wear.tiles:tiles-testing:1.5.0")

    implementation("com.google.guava:guava:33.5.0-jre")

    // To use CallbackToFutureAdapter
    implementation("androidx.concurrent:concurrent-futures:1.3.0")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.10.2")

    // Preview Tools
    implementation("com.google.android.horologist:horologist-compose-tools:0.7.15")
    implementation("com.google.android.horologist:horologist-tiles:0.7.15")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.google.android.horologist:horologist-compose-tools:0.7.15")
    implementation("com.google.android.horologist:horologist-tiles:0.7.15")
    implementation(platform("androidx.compose:compose-bom:2025.09.01"))
    debugImplementation("androidx.compose.ui:ui-tooling:1.9.2")
}