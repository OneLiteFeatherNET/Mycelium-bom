plugins {
    `maven-publish`
}

version = "1.0.0"

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin<MavenPublishPlugin>()
    }
}

allprojects {
    group = "net.theevilreaper.dungeon.bpm"
    version = rootProject.version

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                pom {
                    name.set("${project.name} ${project.version}")
                    description.set("Bill of materials for the Dungeon project")
                    developers {
                        developer {
                            name.set("OneliteFeather")
                            contributors {
                                contributor {
                                    name.set("theEvilReaper")
                                }
                                contributor {
                                    name.set("TheMeinerLP")
                                }
                            }
                        }
                    }

                    issueManagement {
                        system.set("GitLab")
                        url.set("https://gitlab.com/OneliteFeather/dungeon-bom/-/issues")
                    }
                }
            }
        }
    }
}
