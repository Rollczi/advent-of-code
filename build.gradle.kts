plugins {
    id("java-library")
}

group = "dev.rollczi"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

subprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    apply(plugin = "java-library")

    sourceSets.main {
        java {
            srcDir(this.name + "/main")
        }
    }

    sourceSets.test {
        java {
            srcDir(this.name + "/test")
        }
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}