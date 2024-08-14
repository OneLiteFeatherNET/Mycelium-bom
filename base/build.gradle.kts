plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // General dependencies
    includeDependency("net.onelitefeather.microtus", "Microtus", "1.4.2")
    includeDependency("net.onelitefeather.microtus.testing", "testing", "1.4.2")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.17.0")
    includeDependency("org.junit.jupiter", "junit-jupiter-api", "5.11.0")
    includeDependency("org.junit.jupiter", "junit-jupiter-engine", "5.11.0")
    includeDependency("org.mockito", "mockito-core", "5.12.0")
    includeDependency("org.mockito", "mockito-junit-jupiter", "5.12.0")

    // Plugin dependencies
    includeDependency("com.github.johnrengelman.shadow", "shadow", "8.1.1")
}

