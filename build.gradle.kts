plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Web (REST контроллеры)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Reactive WebClient (для второго сервиса)
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Kotlin + Jackson (чтобы JSON красиво мапился)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Для удобной работы с корутинами (опционально)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    // Тесты
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
