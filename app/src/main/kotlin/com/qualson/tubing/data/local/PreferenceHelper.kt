package com.qualson.tubing.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.qualson.tubing.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 4. 18..
 */
@Singleton open class PreferenceHelper @Inject constructor(@ApplicationContext context: Context) {

    private val PREF_FILE_NAME = "tubing_app_pref_file"
    private val PREF_KEY_LOGIN_KEY = "PREF_KEY_LOGIN_KEY"
    private val PREF_LANG = "PREF_KEY_LANG"

    private val mPref: SharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    private val mGson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz").create()

    fun clear() {
        mPref.edit().clear().apply()
    }

    fun putTest(name: String) {
        mPref.edit().putString("test", name).apply()
    }

    fun getTest(name: String) {
        mPref.getString(name, "name")
    }

    fun getLoginKey(): String {
        return mPref.getString(PREF_KEY_LOGIN_KEY, null)
    }

    fun putLoginKey(loginKey: String) {
        mPref.edit().putString(PREF_KEY_LOGIN_KEY, loginKey).apply()
    }

    fun putPrefLang(language: String) {
        mPref.edit().putString(PREF_LANG, language).apply()
    }

    fun getPrefLang(): String {
        return mPref.getString(PREF_LANG, null)
    }
}