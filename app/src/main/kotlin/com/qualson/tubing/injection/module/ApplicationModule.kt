package com.qualson.tubing.injection.module

import android.app.Application
import android.content.Context
import com.qualson.tubing.data.remote.TubingService
import com.qualson.tubing.injection.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 4. 19..
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    internal fun provideTubingService(): TubingService {
        return TubingService.Factory.makeSuperFanService()
    }
}