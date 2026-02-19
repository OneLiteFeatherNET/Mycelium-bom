rootProject.name = "mycelium-bom"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            name = "OneLiteFeatherRepository"
            url = uri("https://repo.onelitefeather.dev/onelitefeather")
            if (System.getenv("CI") != null) {
                credentials {
                    username = System.getenv("ONELITEFEATHER_MAVEN_USERNAME")
                    password = System.getenv("ONELITEFEATHER_MAVEN_PASSWORD")
                }
            } else {
                credentials(PasswordCredentials::class)
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
        }
    }
    versionCatalogs {
        create("libs") {
            version("minestom", "2026.02.19-1.21.11")
            version("adventure", "4.26.1")
            version("junit.bom", "6.0.3")
            version("mockito", "5.21.0")
            version("cyano", "0.5.1")
            version("cyclonedx", "3.2.0")

            library("minestom","net.minestom", "minestom").versionRef("minestom")
            library("cyano", "net.onelitefeather", "cyano").versionRef("cyano")
            library("adventure.minimessage", "net.kyori", "adventure-text-minimessage").versionRef("adventure")

            // Junit libraries
            library("junit.bom", "org.junit", "junit-bom").versionRef("junit.bom")

            // Mock libraries
            library("mockito-core", "org.mockito", "mockito-core").versionRef("mockito")
            library("mockito-junit-jupiter", "org.mockito", "mockito-junit-jupiter").versionRef("mockito")

            plugin("cyclonedx", "org.cyclonedx.bom").versionRef("cyclonedx")
        }
    }
}
