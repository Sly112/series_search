import pl.slyberry.buildsrc.Dependencies
import pl.slyberry.buildsrc.Libraries.implementKoin
import pl.slyberry.buildsrc.Libraries.implementGlide
import pl.slyberry.buildsrc.Libraries.implementNavigation

plugins {
    id("com.android.application")
    id("shared-gradle-plugin")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementKoin()
    implementGlide()
    implementNavigation()

    implementation(Dependencies.EXOPLAYER)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_LOGS)
    implementation(Dependencies.MOSHI_CONVERTER)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIVE_DATA)
    implementation(Dependencies.LIFECYCLE)
    implementation(Dependencies.LIFECYCLE_COMMON)
    implementation(Dependencies.LIFECYCLE_SCOPE)
    implementation(Dependencies.COORDINATOR)
    implementation(Dependencies.LIVE_EVENT)
}
