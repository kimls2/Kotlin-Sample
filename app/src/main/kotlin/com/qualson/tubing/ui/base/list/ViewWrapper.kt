package com.qualson.tubing.ui.base.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by ykim on 2017. 4. 20..
 */
class ViewWrapper<V : View>(var myView: V) : RecyclerView.ViewHolder(myView) {

    fun getView(): V {
        myView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        return myView
    }
}