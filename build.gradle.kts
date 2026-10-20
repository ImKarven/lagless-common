plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jspecify:jspecify:1.0.0")
    compileOnly("org.spongepowered:configurate-yaml:4.2.0")
    implementation("org.slf4j:slf4j-api:2.0.20")
    implementation("org.slf4j:slf4j-simple:2.0.20")
}