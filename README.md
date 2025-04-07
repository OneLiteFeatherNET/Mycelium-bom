## Mycelium Bom

The `Mycelium-Bom` is a project which defines a software bill of materials (SBOM) for the development of minecraft based
server applications which relies on the Microtus project.

> [!NOTE]
> This BOM includes general dependencies that are commonly used across several projects within the OneLiteFeather
> organization.
> However, it does not cover every dependency you might need for your specific project or workflow.
> If you require a particular dependency, you'll need to add it manually to your project.

### What is a BOM?

A "Bill of Materials" (BOM) is a special type of Maven/Gradle artifact that defines a list of dependencies with fixed
versions. The main advantage is that projects using this BOM no longer need to specify individual versions for each
dependency.

### Usage

Gradle (Kotlin DSL):

```kotlin
dependencies {
    implementation(platform("net.theevilreaper.mycelium.bom:mycelium-bom:<version>"))

    // Dependencies without version specification
    implementation("net.onelitefeather.microtus:Microtus")
    implementation("net.kyori:adventure-text-minimessage")
    // ...
}
```

Gradle (Groovy):

```groovy

dependencies {
    implementation platform('net.theevilreaper.mycelium.bom:mycelium-bom:<version>')

    // Dependencies without version specification
    implementation 'net.onelitefeather.microtus:Microtus'
    implementation 'net.kyori:adventure-text-minimessage'
    // ...
}
```
