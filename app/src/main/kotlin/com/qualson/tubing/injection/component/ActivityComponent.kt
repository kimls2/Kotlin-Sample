package com.qualson.tubing.injection.component

import com.qualson.tubing.injection.PerActivity
import com.qualson.tubing.injection.module.ActivityModule
import com.qualson.tubing.ui.main.MainActivity
import dagger.Component

/**
 * Created by ykim on 2017. 4. 19..
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}