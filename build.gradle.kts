// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version DependencyGradle.KOTLIN_VERSION apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}