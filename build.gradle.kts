plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://jitpack.io")
}

dependencies {
    // PowerNukkitX
    compileOnly("cn.powernukkitx:powernukkitx:1.19.70-r2")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    // Depend
    //implementation(files("C:/Users/denis/Desktop/Test Server/plugins/JNPC-1.0-SNAPSHOT.jar"))
}