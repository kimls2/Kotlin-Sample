package com.qualson.tubing.ui.main

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.qualson.tubing.R
import com.qualson.tubing.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ykim on 2017. 4. 21..
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest2 {

    private val idlingResouce: IdlingResource? = null

    @Rule
    @JvmField
    var mainActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test fun inint() {
        val intent = Intent()
        mainActivityTestRule.launchActivity(intent)
        Espresso.onView(ViewMatchers.withId(R.id.mainRv)).check(RecyclerViewItemCountAssertion(0))
    }
}