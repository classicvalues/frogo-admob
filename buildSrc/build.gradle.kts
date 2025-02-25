import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies{
    implementation("com.github.frogobox:open-build-src:1.1.1")
    implementation("com.github.frogobox:frogo-build-src:1.2.3")
}