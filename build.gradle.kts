/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:2.14.1")
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.slf4j:slf4j-log4j12:1.7.31")
    implementation("ca.uhn.hapi.fhir:hapi-fhir-validation:5.6.0-PRE1-SNAPSHOT")
    implementation("ca.uhn.hapi.fhir:hapi-fhir-structures-r4:5.6.0-PRE1-SNAPSHOT")
    implementation("ca.uhn.hapi.fhir:hapi-fhir-validation-resources-r4:5.6.0-PRE1-SNAPSHOT")
}

group = "fhir.abda.de"
version = "0.1.0-SNAPSHOT"
description = "HAPI-Referenz-Validator"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
