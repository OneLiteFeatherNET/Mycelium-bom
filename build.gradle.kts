plugins {
    `maven-publish`
}

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    group = "net.theevilreaper.dungeon"
    version = rootProject.version

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                pom {
                    name.set("${project.name} ${project.version}")
                    description.set("Bill of materials for the Dungeon project")
                    developers {
                        developer {
                            name.set("OneliteFeather")
                        }
                    }
                }
                from(components["java"])
            }
        }
    }

}

