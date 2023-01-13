import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "com.lyr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.mozilla.org/maven2/")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    testImplementation(kotlin("test-junit"))
//    implementation(kotlin("org.web3j:core", "5.0.0"))
    api("org.web3j:core:5.0.0")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}