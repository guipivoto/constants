@file:Suppress("UnstableApiUsage")

import java.util.*
import java.io.FileInputStream
import java.io.FileNotFoundException

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("signing")
}

var signingKeyId = ""
var signingKey = ""
var signingPassword = ""
var ossrhUsername = ""
var ossrhPassword = ""
var sonatypeStagingProfileId = ""

val propsFile = rootProject.file("keystore.properties")
if (propsFile.exists()) {
    val props = Properties().apply {
        load(FileInputStream(propsFile))
    }
    signingKeyId = props.getProperty("signing.keyId")
    signingKey = props.getProperty("signing.key")
    signingPassword = props.getProperty("signing.password")
    ossrhUsername = props.getProperty("ossrhUsername")
    ossrhPassword = props.getProperty("ossrhPassword")
    sonatypeStagingProfileId = props.getProperty("sonatypeStagingProfileId")
} else {
    throw FileNotFoundException("Key store file not found")
}

android {
    namespace  = "com.anandroiddev.constants"
    compileSdk = 33

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

    defaultConfig.apply {
        minSdk = 16
        targetSdk = 33
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

tasks {
    create<Jar>("androidSourcesJar") {
        archiveClassifier.set("sources")
        from(android.sourceSets["main"].java.srcDirs)
        from(android.sourceSets["main"].kotlin)
    }
}

artifacts {
    archives(tasks["androidSourcesJar"])
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                pom {
                    groupId = rootProject.group as String
                    version = rootProject.version as String
                    artifactId = "constants"

                    name.set("An Android Dev Constants")
                    description.set("Small library containing several constants frequently used on any project")
                    url.set("https://anandroiddev.com")

                    from(components.getByName("release"))

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("http://www.opensource.org/licenses/mit-license.php")
                        }
                    }
                    developers {
                        developer {
                            id.set("guipivoto")
                            name.set("Guilherme Pivoto")
                            email.set("guipivoto@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:ssh://example.com/my-library.git")
                        developerConnection.set("scm:git:ssh://example.com/my-library.git")
                        url.set("https://github.com/guipivoto/constants")
                    }
                }
            }
        }
   }

    signing {
        useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
        sign(publishing.publications["mavenJava"])
    }
}
