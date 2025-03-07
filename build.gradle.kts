plugins {
    java
}

version = "2.3.0"

java {
    sourceCompatibility = JavaVersion.toVersion(21)
    targetCompatibility = JavaVersion.toVersion(21)

    disableAutoTargetJvm()
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand(mapOf("version" to version))
        }
    }
}