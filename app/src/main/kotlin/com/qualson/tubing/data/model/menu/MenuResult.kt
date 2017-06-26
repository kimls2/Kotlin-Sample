package com.qualson.tubing.data.model.menu

import com.qualson.tubing.data.model.user.UserResult

/**
 * Created by ykim on 2017. 5. 21..
 */
data class MenuResult(
        val menus: List<MenuModel>? = null,
        val user: UserResult? = null,
        val etc: EtcModel? = null
)