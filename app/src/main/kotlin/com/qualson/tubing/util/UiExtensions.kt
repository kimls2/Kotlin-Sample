package com.qualson.tubing.util

import android.content.Context
import android.view.View

/**
 * Created by ykim on 2017. 4. 20..
 */

fun Int.dpToPx(context: Context): Int = this * context.resources.displayMetrics.density.toInt()

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}


