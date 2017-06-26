package com.qualson.tubing.ui.base

import android.support.annotation.UiThread

/**
 * Created by ykim on 2017. 4. 18..
 */
interface MvpView {

    fun showError(message: String)

    @UiThread fun showLoading(show: Boolean)
}