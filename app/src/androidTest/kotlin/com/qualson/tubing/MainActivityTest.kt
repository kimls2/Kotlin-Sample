package com.qualson.tubing

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.qualson.tubing.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by ykim on 2017. 4. 21..
 */
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    var mainActivityTestRule = ActivityTestRule(
            MainActivity::class.java,
            true,
            false
    )

    @Test
    fun init() {
        val intent = Intent()
        mainActivityTestRule.launchActivity(intent)

        onView(withId(R.id.mainRv)).check(RecyclerViewItemCountAssertion(0))

    }

}