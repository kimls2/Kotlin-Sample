package com.qualson.tubing.data.model.menu

/**
 * Created by ykim on 2017. 5. 21..
 */
data class MenuCategory(
         val name: String,
         val thumbnail: String? = null,
         val link: String? = null,
         val actionType: ActionTypeEnum? = ActionTypeEnum.LINK,
         val id: Int = 0,
         val priority: Int = 0,
         val mediaCount: Int = 0,
         val channelCount: Int = 0,
         val groupCount: Int = 0,
         val level: Boolean = false,
         val released: Boolean = false,

        // custom
         val type: Int = 0

)