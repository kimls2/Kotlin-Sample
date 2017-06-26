package com.qualson.tubing.ui.main.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.qualson.tubing.R
import com.qualson.tubing.data.model.Channel
import kotlinx.android.synthetic.main.item_channel.view.*


/**
 * Created by ykim on 2017. 4. 19..
 */
@SuppressLint("ViewConstructor")
class ChannelView(context: Context?, val adapterCallback: AdapterCallback) : LinearLayout(context) {

    override fun onFinishInflate() {
        View.inflate(context, R.layout.item_channel, this)
        super.onFinishInflate()
    }

    companion object {
        @JvmStatic fun create(context: Context, adapterCallback: AdapterCallback): ChannelView {
            val mInstance = ChannelView(context, adapterCallback)
            mInstance.onFinishInflate()
            return mInstance
        }
    }

    fun bindTo(item: Channel) {
        channelNameTv.text = item.name
        item.categories.forEach {
            val categoryView: CategoryView = CategoryView.create(context, adapterCallback)
            categoryView.bindTo(it)
            categoryRootFrame.addView(categoryView)
        }
    }

}