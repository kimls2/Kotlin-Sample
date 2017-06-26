package com.qualson.tubing.ui.main.list

import com.qualson.tubing.BuildConfig
import com.qualson.tubing.data.model.Category
import com.qualson.tubing.test.common.DefaultConfig
import kotlinx.android.synthetic.main.item_category.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by ykim on 2017. 4. 23..
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(DefaultConfig.EMULATE_SDK), constants = BuildConfig::class)
class CategoryViewTest {

    lateinit var categoryView: CategoryView
    @Mock lateinit var adaperCallback: AdapterCallback
    private val category = Category()

    @Before fun setUp() {
        MockitoAnnotations.initMocks(this)
        categoryView = CategoryView.create(RuntimeEnvironment.application, adaperCallback)

    }

    @Test fun testEmpty() {
        assertThat(categoryView.categoryNameTv.text.toString()).isEmpty()
    }
}