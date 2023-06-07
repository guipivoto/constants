import java.util.*
import java.io.FileInputStream
import java.io.FileNotFoundException

plugins {
    id("com.android.application") version "8.0.1" apply false
    id("com.android.library") version "8.0.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0" apply true
}

group = "com.anandroiddev"
version = "1.0.0"

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

nexusPublishing {
    repositories {
        create("myNexus") {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(ossrhUsername)
            password.set(ossrhPassword)
        }
    }
}
