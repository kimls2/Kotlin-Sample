package com.qualson.tubing.ui.main

import com.qualson.tubing.data.DataManager
import com.qualson.tubing.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ykim on 2017. 4. 18..
 */
class MainPresenter @Inject constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: MainMvpView) {
        super.attachView(view)
    }

    override fun detachView() {
        compositeDisposable.clear()
        super.detachView()
    }

    fun loadMenu() {
        view.showLoading(true)
        compositeDisposable.add(
                dataManager.getMenu()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = {
                                    (code, message, result) ->
                                    if (code == 200)
                                        view.showMenu(result!!) else view.showError(message)

                                }, onError = { view.showError(it.message!!) }
                                , onComplete = { view.showLoading(false) })


        )
    }

    fun saveLoginKey(loginKey: String) {
        dataManager.getPreferenceHelper().putLoginKey(loginKey)
        loadMenu()
    }


}