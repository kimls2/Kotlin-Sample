package com.qualson.tubing.data.model.menu

/**
 * Created by ykim on 2017. 5. 21..
 */
data class MenuResponse(
        val code: Int,
        val message: String,
        val result: MenuResult? = null
)

