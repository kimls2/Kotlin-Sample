package com.qualson.tubing.data.model.user

/**
 * Created by ykim on 2017. 5. 21..
 */
data class User(
         val id: Int = 0,
         val email: String? = null,
         val nickname: String? = null,
         val language: String? = null,
         val type: LoginTypeEnum? = LoginTypeEnum.QUALSON,
         val leftDay: Int = 0,
         val couponCount: Int = 0,
         val password: String? = null,
         val thumbnail: String? = null,
         val pushDisable: Boolean = false

        //    val prefLang(): String
//         {
//            var lang = "한국어"
//            if (this.language!!.contains("en")) {
//                lang = "English"
//            }
//            return lang
//        }
)
