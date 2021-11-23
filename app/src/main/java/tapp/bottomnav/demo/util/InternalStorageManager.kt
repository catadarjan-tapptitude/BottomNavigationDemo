package tapp.bottomnav.demo.util

import android.content.Context
import android.content.SharedPreferences

class InternalStorageManager(context: Context) {

    private val appPreferences: SharedPreferences =
        context.getSharedPreferences(KEY_APP_PREFERENCES, Context.MODE_PRIVATE)

    fun setIsUserLoggedIn(isUserLoggedIn: Boolean) {
        appPreferences.edit().putBoolean(KEY_IS_USER_LOGGED_IN, isUserLoggedIn).apply()
    }

    fun getIsUserLoggedIn(): Boolean = appPreferences.getBoolean(KEY_IS_USER_LOGGED_IN, false)

    companion object {
        private const val KEY_APP_PREFERENCES = "KEY_APP_PREFERENCES"
        private const val KEY_IS_USER_LOGGED_IN = "KEY_IS_USER_LOGGED_IN"
    }
}