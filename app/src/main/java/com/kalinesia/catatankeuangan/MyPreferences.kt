package com.kalinesia.catatankeuangan.com.kalinesia.catatankeuangan

import android.content.Context
import android.preference.PreferenceManager

class MyPreferences(context: Context?) {

    companion object {
        private const val DARK_STATUS = "DARK_STATUS"
        private const val LANG_STATUS = "LANG_STATUS"
    }

    @Suppress("DEPRECATION")
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var darkMode = preferences.getInt(DARK_STATUS, 0)
        set(value) = preferences.edit().putInt(DARK_STATUS, value).apply()

    var langMode = preferences.getInt(LANG_STATUS, 0)
        set(value) = preferences.edit().putInt(LANG_STATUS, value).apply()

}