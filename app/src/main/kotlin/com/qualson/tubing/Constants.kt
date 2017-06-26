package com.qualson.tubing

/**
 * Created by ykim on 2017. 4. 6..
 */

object Constants {

    val TUBING_URL_BASE = "http://www.tubingenglish.com"

    val TUBING_APP_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj8ce0EwcbMpgtOXyq7nyB0w/Q3tfs3aD7j9CLljQX+HfVXeRi6wnAxhvUYbKgVKouRxvOnewHezugTR2EjNbS07ijz82Hpt5lU4wlCBgxiPHIsuyZUmeXxkN2LTows8ai0Zf82e39SinFljPi5seJDzL6J79EgTTHxCKTBcSaWX6RHSTfgqWI4DO8KI1pwWxIn4OHgz7QnY7FsDTxBO3uXYUklveE7jXaSIQAIgDHMzyANHxJUikaadr3fOgTHZxIjpM6AN1Z94KjjRMRHr2x2mco9MLVn/LcXUn/4+mY04LjcGwjp5hKCxJdPFWmGF84RbF+aXmeC6C0hjRXbP/OQIDAQAB"

    val settingUrl: String
        get() = TUBING_URL_BASE + "/user/setting"

    val helpUrl: String
        get() = TUBING_URL_BASE + "/user/help/faq"

    val loginUrl: String
        get() = TUBING_URL_BASE + "/login"

}
