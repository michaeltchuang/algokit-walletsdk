buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.ksp.gradle.plugin)
    }
}

plugins {
    id("com.android.application") version libs.versions.agp apply false
    id("com.android.library") version libs.versions.agp apply false
    id("androidx.privacysandbox.library") version libs.versions.privacySandboxBuildPlugin apply false
    id("com.google.devtools.ksp") version libs.versions.ksp apply false
    id("org.jetbrains.kotlin.jvm") version libs.versions.kotlin apply false
    id("org.jetbrains.kotlin.android") version libs.versions.kotlin apply false
    alias(libs.plugins.compose.compiler) apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
