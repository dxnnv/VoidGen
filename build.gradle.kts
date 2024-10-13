plugins {
    java
}

group = project.properties["plugin_group"] as String
version = project.properties["plugin_version"] as String

java {
    sourceCompatibility = JavaVersion.toVersion(21)
    targetCompatibility = JavaVersion.toVersion(21)

    disableAutoTargetJvm()
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand(
                mapOf(
                    "version" to project.properties["plugin_version"],
                    "name" to project.properties["plugin_name"],
                    "group" to project.properties["plugin_group"],
                    "website" to project.properties["plugin_website"],
                    "author" to project.properties["plugin_author"]
                )
            )
        }
    }
}