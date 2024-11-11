plugins {
    id("java")
}

group = "com.luddwg"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.1")

    implementation("org.xmlunit:xmlunit-assertj3:2.10.0")
    implementation("org.xmlunit:xmlunit-core:2.10.0")
}
