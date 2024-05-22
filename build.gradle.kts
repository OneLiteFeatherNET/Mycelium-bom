plugins {
    `maven-publish`
}

version = "1.0.3"

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin<MavenPublishPlugin>()
    }
}

subprojects {
    group = "net.theevilreaper.dungeon.bom"
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
}
