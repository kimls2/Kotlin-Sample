package com.qualson.tubing.data.model.menu

/**
 * Created by ykim on 2017. 5. 21..
 */
data class MenuModel(
         val name: String? = null,
         val linkType: LinkTypeEnum? = LinkTypeEnum.CATEGORY,
         val categories: List<MenuCategory>? = null,

        // custom
         val type: Int = 0
)
