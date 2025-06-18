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
            version("minestom", "a1d1920a04")
            version("adventure", "4.23.0")
            version("junit", "5.13.1")
            version("junit.platform", "1.13.1")
            version("mockito", "5.18.0")
            version("cyano", "0.1.1")

            library("minestom","net.minestom", "minestom-snapshots").versionRef("minestom")
            library("cyano", "net.onelitefeather", "cyano").versionRef("cyano")
            library("adventure.minimessage", "net.kyori", "adventure-text-minimessage").versionRef("adventure")

            // Junit libraries
            library("junit.jupiter.api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit.jupiter.engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
            library("junit.jupiter.params", "org.junit.jupiter", "junit-jupiter-params").versionRef("junit")
            library("junit.platform.launcher", "org.junit.platform", "junit-platform-launcher").versionRef("junit.platform")

            // Mock libraries
            library("mockito-core", "org.mockito", "mockito-core").versionRef("mockito")
            library("mockito-junit-jupiter", "org.mockito", "mockito-junit-jupiter").versionRef("mockito")
        }
    }
}
