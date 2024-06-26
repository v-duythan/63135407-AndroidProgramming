plugins {
    id("com.android.application")
}

android {
    namespace = "ntu.vdt63135407.usingbottomnavigationview"
    compileSdk = 34

    defaultConfig {
        applicationId = "ntu.vdt63135407.usingbottomnavigationview"
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
    dependencies {
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.3.0-alpha03") // Thêm dòng này
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }

}