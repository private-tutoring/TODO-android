package com.example.checktest

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context, fileName: String) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    fun init() {
        prefs.edit().clear().commit()
    }

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun deleteString(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun getAllString(): MutableMap<String, *>? {
        return prefs.all
    }
}