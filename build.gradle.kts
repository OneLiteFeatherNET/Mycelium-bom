plugins {
    `maven-publish`
    `java-platform`
}

group = "net.theevilreaper.mycelium.bom"
version = "1.1.1"

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api(libs.microtus)
        api(libs.microtus.testing)
        api(libs.adventure.text.minimessage)
        api(libs.junit.jupiter.api)
        api(libs.junit.jupiter.engine)
        api(libs.mockito.core)
        api(libs.mockito.junit.jupiter)
    }
}


publishing {
    repositories {
        maven {
            authentication {
                credentials(PasswordCredentials::class) {
                    // Those credentials need to be set under "Settings -> Secrets -> Actions" in your repository
                    username = System.getenv("ONELITEFEATHER_MAVEN_USERNAME")
                    password = System.getenv("ONELITEFEATHER_MAVEN_PASSWORD")
                }
            }
            name = "OneLiteFeatherRepository"
            url = if (project.version.toString().contains("SNAPSHOT")) {
                uri("https://repo.onelitefeather.dev/onelitefeather-snapshots")
            } else {
                uri("https://repo.onelitefeather.dev/onelitefeather-releases")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            pom {
                name.set("${project.name} ${project.version}")
                description.set("Bill of materials for the Mycelium project")
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
                    system.set("Github")
                    url.set("https://github.com/OneLiteFeatherNET/Mycelium-bom/issues")
                }
            }
        }
    }
}
