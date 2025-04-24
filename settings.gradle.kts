rootProject.name = "mycelium-bom"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("minestom", "a1d1920a04")
            version("adventure", "4.20.0")
            version("junit", "5.12.2")
            version("mockito", "5.17.0")

            library("minestom","net.minestom", "minestom-snapshots").versionRef("minestom")
            library("adventure-text-minimessage", "net.kyori", "adventure-text-minimessage").versionRef("adventure")
            library("junit-jupiter-api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
            library("mockito-core", "org.mockito", "mockito-core").versionRef("mockito")
            library("mockito-junit-jupiter", "org.mockito", "mockito-junit-jupiter").versionRef("mockito")
        }
    }
}
