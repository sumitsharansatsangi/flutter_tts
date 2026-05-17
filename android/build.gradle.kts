import org.jetbrains.kotlin.gradle.dsl.JvmTarget

def args = ["-Xlint:deprecation"]


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

group = "com.eyedeadevelopment.fluttertts"
version = "1.0-SNAPSHOT"

repositories {
        google()
        mavenCentral()
    }

project.getTasks().withType(JavaCompile).configureEach {
    options.compilerArgs.addAll(args)
}

android {
    compileSdk = 37
     namespace = "com.eyedeadevelopment.fluttertts"

    defaultConfig {
        minSdkVersion = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lintOptions {
        disable = "InvalidPackage"
        disable = "GradleDependency"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}
repositories {
    mavenCentral()
}
