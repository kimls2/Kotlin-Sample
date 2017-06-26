package com.qualson.tubing.ui.base.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by ykim on 2017. 4. 20..
 */
abstract class RecyclerViewAdapterBase<T, V : View> : RecyclerView.Adapter<ViewWrapper<V>>() {
    protected var items: MutableList<T>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewWrapper<V> {
        return ViewWrapper(onCreateItemView(parent, viewType))
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    protected abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V
}