plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation(platform("software.amazon.awssdk:bom:2.27.21"))
//    implementation("software.amazon.awssdk:s3")
    implementation("aws.sdk.kotlin:s3:1.2.38")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}