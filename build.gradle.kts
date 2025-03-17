plugins {
    `maven-publish`
    `java-platform`
}

group = "net.theevilreaper.mycelium.bom"
version = "1.1.0"

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

        if (System.getenv().containsKey("CI")) {
            repositories {
                maven {
                    name = "GitLab"
                    val ciApiv4Url = System.getenv("CI_API_V4_URL")
                    val projectId = System.getenv("CI_PROJECT_ID")
                    url = uri("$ciApiv4Url/projects/$projectId/packages/maven")
                    credentials(HttpHeaderCredentials::class.java) {
                        name = "Job-Token"
                        value = System.getenv("CI_JOB_TOKEN")
                    }
                    authentication {
                        create<HttpHeaderAuthentication>("header")
                    }
                }
            }
        }
    }
}
