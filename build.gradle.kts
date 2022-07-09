import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("org.graalvm.buildtools.native") version "0.9.12"

}

group = "au.id.wale.enter.the.gecko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:4.27.1.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-undertow")
    implementation("org.http4k:http4k-client-apache")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

graalvmNative {
    binaries {
        named("main") {
            // Main options
            imageName.set("gex")
            mainClass.set("au.id.wale.enter.the.gecko.MainKt")

            excludeConfig.put(file("$buildDir/libs/*.jar"), listOf("META-INF/native-image/*", "config/*"))

            // Advanced options
            buildArgs.add("-H:Extra")
            jvmArgs.add("flag")

            useFatJar.set(true)
        }
    }
}

