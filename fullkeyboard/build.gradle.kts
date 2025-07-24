plugins {
    alias(libs.plugins.android.library)
    id("io.github.jeadyx.sonatype-uploader") version "2.8"
}

android {
    namespace = "com.android.desert.fullkeyboard"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
//    android.libraryVariants.all {
//        val buildType = this.buildType.name
//        val version = "1.0.0"
//        outputs.all {
//            if (this is com.android.build.gradle
//                .internal.api.LibraryVariantOutputImpl) {
//                this.outputFileName = "android-fullkeyboard-master-" +
//                        "${version}.aar"
//            }
//        }
//    }
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

