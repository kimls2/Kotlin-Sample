package com.qualson.tubing.data.model

/**
 * Created by ykim on 2017. 4. 18..
 */
data class Channel(
        var id: Int = -1,
        var name: String = "",
        var priority: Int = -1,
        var released: Boolean = false,
        var deleted: Boolean = false,
        var categories: MutableList<Category> = ArrayList(),
        var type: Int = -1,
        var login: Boolean = false
)