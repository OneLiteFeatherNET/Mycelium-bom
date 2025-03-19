plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // General dependencies
    includeDependency("net.onelitefeather.microtus", "Microtus", "1.5.1")
    includeDependency("net.onelitefeather.microtus.testing", "testing", "1.5.1")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.19.0")
    includeDependency("org.junit.jupiter", "junit-jupiter-api", "5.11.3")
    includeDependency("org.junit.jupiter", "junit-jupiter-engine", "5.11.3")
    includeDependency("org.mockito", "mockito-core", "5.16.1")
    includeDependency("org.mockito", "mockito-junit-jupiter", "5.16.1")

    // Plugin dependencies
    includeDependency("com.gradleup.shadow", "shadow", "8.3.6")
}

