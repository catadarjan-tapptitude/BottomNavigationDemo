package tapp.bottomnav.demo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tapp.bottomnav.demo.util.internalStorageManager

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(internalStorageManager)
        }
    }
}