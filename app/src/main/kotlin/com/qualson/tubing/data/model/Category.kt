package com.qualson.tubing.data.model

/**
 * Created by ykim on 2017. 4. 18..
 */
data class Category(
        var id: Int = -1,
        var name: String = "",
        var priority: Int = -1,
        var mediaCount: Int = -1,
        var channelCount: Int = -1,
        var groupCount: Int = -1,
        var level: Boolean = false,
        var released: Boolean = false,
        var mobileLink: String = "about:blank",
        // custom
        var type: Int = -1,
        var login: Boolean = false
)