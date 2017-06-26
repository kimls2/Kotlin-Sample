package com.qualson.tubing.ui.main.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.qualson.tubing.R
import com.qualson.tubing.data.model.Category
import kotlinx.android.synthetic.main.item_category.view.*


/**
 * Created by ykim on 2017. 4. 19..
 */
@SuppressLint("ViewConstructor")
class CategoryView(context: Context?, val adapterCallback: AdapterCallback) : LinearLayout(context) {

    override fun onFinishInflate() {
        View.inflate(context, R.layout.item_category, this)
        super.onFinishInflate()
    }

    companion object {
        @JvmStatic fun create(context: Context, adapterCallback: AdapterCallback): CategoryView {
            val mInstance = CategoryView(context, adapterCallback)
            mInstance.onFinishInflate()
            return mInstance
        }
    }

    fun bindTo(category: Category) {
        categoryNameTv.text = category.name
        if (category.level) {
            levelIv.visibility = View.VISIBLE
            if (category.name.contains("1")) {
                levelIv.setImageResource(R.drawable.menu_level1)
            } else if (category.name.contains("2")) {
                levelIv.setImageResource(R.drawable.menu_level2)
            } else if (category.name.contains("3")) {
                levelIv.setImageResource(R.drawable.menu_level3)
            }
        } else {
            levelIv.visibility = View.GONE
        }

        this.setOnClickListener {
            adapterCallback.itemOnClicked(category.mobileLink)
        }
    }
}