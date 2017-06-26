package com.qualson.tubing.ui.base

/**
 * Created by ykim on 2017. 4. 19..
 */
interface Presenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}