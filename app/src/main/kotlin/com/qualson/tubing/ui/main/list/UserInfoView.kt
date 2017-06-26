package com.qualson.tubing.ui.main.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.qualson.tubing.R
import com.qualson.tubing.data.model.Channel
import kotlinx.android.synthetic.main.layout_user_info.view.*


/**
 * Created by ykim on 2017. 4. 20..
 */
@SuppressLint("ViewConstructor")
class UserInfoView(context: Context, adapterCallback: AdapterCallback) : LinearLayout(context) {


    override fun onFinishInflate() {
        View.inflate(context, R.layout.layout_user_info, this)
        super.onFinishInflate()
    }

    companion object {
        @JvmStatic fun create(context: Context,
                              adapterCallback: AdapterCallback): UserInfoView {
            val instance = UserInfoView(context, adapterCallback)
            instance.onFinishInflate()
            return instance
        }
    }


    fun bindTo(item: Channel) {
        // login?
        if (item.login) {
            loginLayout.visibility = View.GONE
            userInfoLayout.visibility = View.VISIBLE
            navigationAddLayout.visibility = View.VISIBLE
            if (navigationAddLayout.childCount > 0) {
                navigationAddLayout.removeAllViews()
            }

            // test
//            navigationAddLayout.addView(NavigationView.build(context, mAdapterCallbackInterface))

        } else {
            loginLayout.visibility = View.VISIBLE
            userInfoLayout.visibility = View.GONE
            navigationAddLayout.visibility = View.GONE
//            mLoginFrame!!.setOnClickListener { mAdapterCallbackInterface.itemOnClicked(Constants.loginUrl) }
        }
    }


}
