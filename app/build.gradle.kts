plugins {
    id("com.android.application")
}

android {
    namespace = "fpl.poly.nhom9.duan1ht"
    compileSdk = 34

    defaultConfig {
        applicationId = "fpl.poly.nhom9.duan1ht"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("me.relex:circleindicator:2.1.6")
    implementation("androidx.recyclerview:recyclerview:1.3.2")

//    compileOnly("com.chauthai.swipereveallayout:swipe-reveal-layout:1.4.1")




//
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.10.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("com.github.dhaval2404:imagepicker:2.1")

//    implementation("junit:junit:4.13.2")
//    implementation("androidx.test.ext:junit:1.1.5")
//    implementation("androidx.test.espresso:espresso-core:3.5.1")
//    implementation("androidx.recyclerview:recyclerview:1.3.2")
//    implementation("com.chauthai.swipereveallayout:swipe-reveal-layout:1.4.1")
//    implementation("me.relex:circleindicator:2.1.6")
//    implementation("com.google.android.material:material:<version>")
//    implementation("com.github.bumptech.glide:glide:4.15.1")
}

