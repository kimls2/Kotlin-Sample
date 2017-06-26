package com.qualson.tubing.ui.base

/**
 * Created by ykim on 2017. 4. 18..
 */
open class BasePresenter<T : MvpView> : Presenter<T> {

    private var _view: T? = null
    var isViewAttached: Boolean = _view != null

    val view: T
        get() {
            return _view ?: throw MvpViewNotAttachedException()
        }

    override fun attachView(view: T) {
        _view = view
    }

    override fun detachView() {
        _view = null
    }

    class MvpViewNotAttachedException : RuntimeException(
            "Please call Presenter.attachView(MvpView) before requesting data to the Presenter")

}