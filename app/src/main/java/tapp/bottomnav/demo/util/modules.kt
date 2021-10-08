package tapp.bottomnav.demo.util

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val internalStorageManager = module {
    single { InternalStorageManager(androidContext()) }
}