plugins {
    id("com.android.application")
    //id 'kotlin-kapt'
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.remittanceapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.remittanceapp"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val nav_version = "2.7.7"

    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    //implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    //implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:2.7.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.44")
    annotationProcessor("androidx.hilt:hilt-compiler:1.2.0")

    //RxJava
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation("io.reactivex.rxjava3:rxjava:3.0.0")

    // Datastore
    implementation("androidx.datastore:datastore-preferences:1.1.0")

    //sdp
    implementation("com.intuit.sdp:sdp-android:1.0.6")

}