plugins {
    kotlin("jvm") version "1.9.22"
    application
}

application {
    mainClass.set("org.example.binaryTree.MainKt")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation(kotlin("stdlib"))
}

tasks.test {
    useJUnitPlatform()
}