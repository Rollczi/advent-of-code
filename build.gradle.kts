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
            srcDir(this.name)
        }
    }

}