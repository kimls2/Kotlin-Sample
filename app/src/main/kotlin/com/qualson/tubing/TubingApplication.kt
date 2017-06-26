package com.qualson.tubing

import android.app.Application
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.facebook.stetho.Stetho
import com.qualson.tubing.injection.component.ApplicationComponent
import com.qualson.tubing.injection.component.DaggerApplicationComponent
import com.qualson.tubing.injection.module.ApplicationModule
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import java.util.*

/**
 * Created by ykim on 2017. 4. 18..
 */

class TubingApplication : Application() {

    lateinit var mApplicationComponent: ApplicationComponent
    lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()
        initDaggerComponent()
        CalligraphyConfig.initDefault(
                CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.NotoSans_Regular))
                        .setFontAttrId(R.attr.fontPath)
                        .build())

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            refWatcher = LeakCanary.install(this)
        } else {
            // fabric

        }
    }

    fun initDaggerComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun getDeviceId(): String {
        var deviceId = "UNKNOWN_DEVICE_ID"
        try {
            deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            +Build.BOARD.length % 10
            +Build.BRAND.length % 10
            +Build.DEVICE.length % 10
            +Build.DISPLAY.length % 10
            +Build.HOST.length % 10
            +Build.ID.length % 10
            +Build.MANUFACTURER.length % 10
            +Build.MODEL.length % 10
            +Build.PRODUCT.length % 10
            +Build.TAGS.length % 10
            +Build.TYPE.length % 10
            +Build.USER.length % 10
            Build.SERIAL
        } catch (ignore: Exception) {

        }

        return deviceId
    }

    fun getAppVersion(): String {
        try {
            val packageInfo = applicationContext.packageManager
                    .getPackageInfo(applicationContext.packageName, 0)
            return packageInfo.versionName
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    fun getQueryParams(): Map<String, String> {
        val params = HashMap<String, String>()
        params.put("device", Build.MODEL)
        params.put("osVersion", Build.VERSION.SDK_INT.toString())
        params.put("appVersion", getAppVersion())
        params.put("osType", "ANDROID")
//        if (FirebaseApp.getInstance() != null) {
//            params.put("pushId", FirebaseInstanceId.getInstance().token as String)
//            Timber.e(" pushId : %s", FirebaseInstanceId.getInstance().token)
//        }
        params.put("deviceId", getDeviceId())
        params.put("language", Locale.getDefault().language)
        params.put("country", Locale.getDefault().country)
        return params
    }

    companion object {
        @JvmStatic fun get(context: Context): TubingApplication {
            return context.applicationContext as TubingApplication
        }

        @JvmStatic fun getRefWatcher(context: Context): RefWatcher {
            val application = context.applicationContext as TubingApplication
            return application.refWatcher
        }
    }

}