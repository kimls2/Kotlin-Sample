package com.qualson.tubing.injection.component

import android.app.Application
import android.content.Context
import com.qualson.tubing.TubingApplication
import com.qualson.tubing.data.DataManager
import com.qualson.tubing.data.local.PreferenceHelper
import com.qualson.tubing.data.remote.TubingService
import com.qualson.tubing.injection.ApplicationContext
import com.qualson.tubing.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 4. 19..
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(tubingApplication: TubingApplication)

    @ApplicationContext fun context(): Context
    fun application(): Application
    fun tubingService(): TubingService
    fun preferenceHelper(): PreferenceHelper
    fun dataManager(): DataManager
}