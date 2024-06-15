plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.cazulabs.mylogin"
    compileSdk = 34

    task("appRelease") {
        doLast {
            file("./versionName.txt").writeText("SOY GIGANTON")
            /*
            if(android.defaultConfig.versionName.isNullOrEmpty())
                file("./version.txt").writeText("almorrana")
            else
                file("./version.txt").writeText(android.defaultConfig.versionName.toString() + " OSEBUCO")
                */
        }
    }

    flavorDimensions.add("debug")
    productFlavors {
        create("free") {
            dimension = "debug"
            val appName = "My Login"
            manifestPlaceholders["appName"] = appName
            applicationIdSuffix = ".demo"
            versionName = "3.0"
            versionNameSuffix = ".3"
            versionCode = (versionName + versionNameSuffix).replace(".", "").toInt()
            val apkName = "${appName}_$versionName$versionNameSuffix($versionCode)debug.apk"

            // change app name block below
            buildOutputs.all {
                val variantOutputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
                variantOutputImpl.outputFileName =  apkName
            }
        }
    }


    defaultConfig {
        applicationId = "com.cazulabs.mylogin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "v3.0_240607"

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

    //NAVIGATION
    implementation(libs.androidx.navigation.compose)

    //ICONS EXTENDED
    implementation(libs.androidx.material.icons.extended)

    //UPDATE FROM KAPT TO KSP WHEN DAGGER HILT COMPATIBLE

    //DAGGER HILT
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    //VIEWMODEL
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //VIEWMODEL Compose utilities
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    //LIVEDATA
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.androidx.runtime.livedata)
    //Annotation processor
    implementation(libs.androidx.lifecycle.common.java8)

    //RETROFIT
    implementation(libs.retrofit)
    //GSON
    implementation(libs.converter.gson)

    //ROOM
    implementation(libs.androidx.room.runtime)
    //Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
    //Annotation processor
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)


}