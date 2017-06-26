package com.qualson.tubing.injection

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(value = RUNTIME)
annotation class PerActivity