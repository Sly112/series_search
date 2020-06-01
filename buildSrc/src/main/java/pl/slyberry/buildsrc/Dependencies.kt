package pl.slyberry.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
  const val LIFECYCLE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
  const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
  const val LIFECYCLE_SCOPE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
  const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"

  const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
  const val COORDINATOR = "androidx.constraintlayout:constraintlayout:${Versions.COORDINATOR}"
  const val LIVE_EVENT = "com.github.hadilq.liveevent:liveevent:${Versions.LIVE_EVENT}"

  const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
  const val RETROFIT_LOGS = "com.squareup.okhttp3:logging-interceptor:${Versions.RETROFIT_LOGS}"
  const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
  const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"

  const val EXOPLAYER = "com.google.android.exoplayer:exoplayer:${Versions.EXOPLAYER}"

  object Core {
    const val CORE = "androidx.core:core:${Versions.CORE}"
    const val MEDIA = "androidx.media:media:${Versions.CORE}"
  }

  object Glide {
    const val MAIN = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
  }

  object Koin {
    const val MAIN = "org.koin:koin-android:${Versions.KOIN}"
    const val SCOPE = "org.koin:koin-android-scope:${Versions.KOIN}"
    const val VIEW_MODEL = "org.koin:koin-android-viewmodel:${Versions.KOIN}"
    const val TEST = "org.koin:koin-test:${Versions.KOIN}"
  }

  object Navigation {
    const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
  }
}

object Versions {
  const val LIFECYCLE = "2.2.0"
  const val MATERIAL = "1.1.0"
  const val COORDINATOR = "2.0.0-beta4"
  const val KOIN = "2.1.5"
  const val LIVE_EVENT = "1.2.0"
  const val RETROFIT = "2.9.0"
  const val RETROFIT_LOGS = "3.8.0"
  const val GLIDE = "4.11.0"
  const val COROUTINES = "1.3.7"
  const val CORE = "1.1.0"
  const val EXOPLAYER = "2.11.4"
  const val NAVIGATION = "2.2.2"
}

object Libraries {

  fun DependencyHandler.implementCore() {
    add("implementation", Dependencies.Core.CORE)
    add("implementation", Dependencies.Core.MEDIA)
  }

  fun DependencyHandler.implementGlide() {
    add("implementation", Dependencies.Glide.MAIN)
  }

  fun DependencyHandler.implementKoin() {
    add("implementation", Dependencies.Koin.MAIN)
    add("implementation", Dependencies.Koin.SCOPE)
    add("implementation", Dependencies.Koin.VIEW_MODEL)
  }

  fun DependencyHandler.implementNavigation() {
    add("implementation", Dependencies.Navigation.FRAGMENT)
    add("implementation", Dependencies.Navigation.UI)
  }
}
