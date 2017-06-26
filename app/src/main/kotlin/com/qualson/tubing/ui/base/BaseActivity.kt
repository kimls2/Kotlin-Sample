package com.qualson.tubing.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qualson.tubing.BuildConfig
import com.qualson.tubing.TubingApplication
import com.qualson.tubing.injection.component.ActivityComponent
import com.qualson.tubing.injection.component.DaggerActivityComponent

/**
 * Created by ykim on 2017. 4. 18..
 */

abstract class BaseActivity : AppCompatActivity() {

    protected var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent((applicationContext as TubingApplication).mApplicationComponent).build()

    }

    protected abstract fun getLayoutResId(): Int

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) {
            TubingApplication.get(this).refWatcher.watch(this)
        }
    }

}