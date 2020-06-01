repositories {
    jcenter()
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("shared-gradle-plugin") {
            id = "shared-gradle-plugin"
            implementationClass = "pl.slyberry.buildsrc.SharedGradlePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.0.0")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.2")
    implementation(kotlin("gradle-plugin", "1.3.72"))
    implementation(kotlin("android-extensions"))
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}