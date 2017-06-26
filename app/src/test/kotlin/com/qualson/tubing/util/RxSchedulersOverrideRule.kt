package com.qualson.tubing.util

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Created by ykim on 2017. 4. 20..
 */
class RxSchedulersOverrideRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                // before
                RxAndroidPlugins.reset()
                RxJavaPlugins.reset()
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
                RxJavaPlugins.setIoSchedulerHandler({ Schedulers.trampoline() })

                base.evaluate()

                // after
                RxAndroidPlugins.reset()
                RxJavaPlugins.reset()
            }
        }
    }
}