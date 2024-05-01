plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.cazulabs.mylogin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cazulabs.mylogin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {

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

    //DAGGER HILT
    implementation(libs.hilt.android) //"com.google.dagger:hilt-android:2.46"
    kapt(libs.hilt.compiler) //"com.google.dagger:hilt-compiler:2.46"

    //VIEWMODEL
    implementation(libs.androidx.lifecycle.viewmodel.ktx) //"androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
    //VIEWMODEL Compose utilities
    implementation(libs.androidx.lifecycle.viewmodel.compose) //"androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0"
    // LIVEDATA
    implementation(libs.lifecycle.livedata.ktx) //"androidx.lifecycle:lifecycle-livedata-ktx:2.7.0"
    //Annotation processor
    implementation(libs.androidx.lifecycle.common.java8) //"androidx.lifecycle:lifecycle-common-java8:2.7.0"


}