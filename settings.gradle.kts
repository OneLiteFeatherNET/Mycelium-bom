rootProject.name = "mycelium-bom"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://repo.onelitefeather.dev/releases")
    }
    versionCatalogs {
        create("libs") {
            version("minestom", "2026.08.16-26.2")
            version("adventure", "5.2.0")
            version("junit.bom", "6.1.3")
            version("mockito", "5.23.0")
            version("cyano", "0.7.4")
            version("cyclonedx", "3.4.1")

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
