import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val compilerArgs = listOf("-Xlint:deprecation")

plugins {
    id("com.android.library")
}

group = "com.eyedeadevelopment.fluttertts"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.addAll(compilerArgs)
}

extensions.configure<LibraryExtension>("android") {

    namespace = "com.eyedeadevelopment.fluttertts"

    compileSdk = 37

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        disable.add("InvalidPackage")
        disable.add("GradleDependency")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}