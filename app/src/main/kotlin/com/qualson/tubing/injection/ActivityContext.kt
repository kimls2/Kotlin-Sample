package com.qualson.tubing.injection

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by ykim on 2017. 4. 19..
 */
@Qualifier
@Retention(value = RUNTIME)
annotation class ActivityContext