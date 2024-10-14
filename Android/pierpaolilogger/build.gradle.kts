plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.pierpaoli.pierpaolilogger"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.register<Copy>("copyBuild")
{
    dependsOn(tasks.named("assembleRelease"))
    from("build/outputs/aar")
    include(project.name + "-release.aar")
    into("../../../Plugin_Moviles_Pierpaoli/Assets/Plugins/Android")
    doFirst {
        println("Copiando archivo .aar a ../../../Plugin_Moviles_Pierpaoli/Assets/Plugins/Android")
    }
}