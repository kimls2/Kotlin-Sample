package com.qualson.tubing.data.model.user

import com.qualson.tubing.data.model.menu.MenuCategory

/**
 * Created by ykim on 2017. 5. 21..
 */
data class UserResult(
         val user: User,
         val categories: List<MenuCategory>? = null
)