// Settings plugin
pluginManagement {
    repositories {
        google()            // This is the most important one for com.android.application
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "小说阅读器"
include(":app")

// Project-level build.gradle.kts
plugins {
    // These define the versions but don't "run" the plugin here
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.21" apply false
}

// Corrected Task syntax for Kotlin DSL
tasks.register("initMessage") {
    doLast {
        println("📖 小说阅读器 App 项目初始化中...")
    }
}