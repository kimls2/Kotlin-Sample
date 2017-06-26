package com.qualson.tubing.ui.main

import com.qualson.tubing.data.model.Channel
import com.qualson.tubing.data.model.menu.MenuResult
import com.qualson.tubing.ui.base.MvpView

/**
 * Created by ykim on 2017. 4. 18..
 */
interface MainMvpView : MvpView {

    fun showCategories(channel: MutableList<Channel>)

    fun showMenu(result: MenuResult)

    fun logout()

    fun setCookie(authKey: String)

    fun userLeave()
}