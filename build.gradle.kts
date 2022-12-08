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

    // add task to start class with main method
    // example: gradle run -Pday=1
    tasks.register("run", JavaExec::class.java) {
        group = "application"
        description = "Runs this project as a Java application."

        classpath = sourceSets.main.get().runtimeClasspath

        mainClass.set("dev.rollczi.adventofcode" + this@subprojects.name + ".day" + project.findProperty("day") + ".Day" + project.findProperty("day"))
        workingDir = workingDir.parentFile
    }


}