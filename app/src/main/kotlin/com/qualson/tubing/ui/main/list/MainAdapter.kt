package com.qualson.tubing.ui.main.list

import android.view.View
import android.view.ViewGroup
import com.qualson.tubing.data.model.Channel
import com.qualson.tubing.ui.base.list.RecyclerViewAdapterBase
import com.qualson.tubing.ui.base.list.ViewWrapper

/**
 * Created by ykim on 2017. 4. 20..
 */
class MainAdapter constructor(val adapterCallback: AdapterCallback) : RecyclerViewAdapterBase<Channel, View>() {

    companion object {
        val USER_INFO = 1
        val NAVIGATION = 3
        val GROUP = 2
    }

    fun setData(list: MutableList<Channel>) {
        items?.clear()
        addEmptyItem(items!!, USER_INFO)
        items?.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): View {
        when (viewType) {
            USER_INFO -> return UserInfoView.create(parent.context, adapterCallback)
            else -> return ChannelView.create(parent.context, adapterCallback)
        }

    }

    override fun onBindViewHolder(holder: ViewWrapper<View>?, position: Int) {
        when (getItemViewType(position)) {
            USER_INFO -> {
                val userInfoView: UserInfoView = holder!!.getView() as UserInfoView
                userInfoView.bindTo(items!![position])
            }

            else -> {
                val view: ChannelView = holder!!.getView() as ChannelView
                view.bindTo(items!![position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items?.get(position)!!.type
    }

    private fun addEmptyItem(list: MutableList<Channel>, viewType: Int) {
        val emptyChannel: Channel = Channel()
        emptyChannel.type = viewType
        list.add(emptyChannel)
    }
}