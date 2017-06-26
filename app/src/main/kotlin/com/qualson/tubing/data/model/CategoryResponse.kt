package com.qualson.tubing.data.model

/**
 * Created by ykim on 2017. 4. 18..
 */
data class CategoryResponse(
        var message: String = "",
        var code: Int = 200,
        var result: MutableList<Channel> = ArrayList()
)