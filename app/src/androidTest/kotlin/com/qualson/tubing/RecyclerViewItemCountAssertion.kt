package com.qualson.tubing

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.v7.widget.RecyclerView
import android.view.View

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat


/**
 * Created by ykim on 2017. 4. 21..
 */
class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {

    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter

        assertThat(adapter.itemCount, `is`(expectedCount))
    }
}