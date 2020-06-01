package pl.slyberry.series

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SeriesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SeriesApp)
            modules(koinModule)
        }
    }
}
