plugins {
    id("com.android.application")
}

android {
    namespace = "com.regexbyte.habittracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.regexbyte.habittracker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.11.0")
    implementation ("com.google.android.material:material:1.4.0")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.hannesdorfmann.mosby3:mvp:3.1.1")
    testImplementation("junit:junit:4.13.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter

    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1") // Logging interceptor (optional)

    // Gson (if not using converter-gson)
    implementation("com.google.code.gson:gson:2.8.8")
    implementation ("com.github.bumptech.glide:glide:4.12.0") // Use the latest version available
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")



    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

