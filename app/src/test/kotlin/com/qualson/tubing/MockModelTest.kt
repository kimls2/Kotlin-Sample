package com.qualson.tubing

import com.qualson.tubing.data.model.CategoryResponse
import com.qualson.tubing.test.common.MockModelFabric
import org.amshove.kluent.shouldEqual
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ykim on 2017. 4. 20..
 */
class MockModelTest {
    @Test fun testModel() {
        val categoryResponse: CategoryResponse = MockModelFabric.newCategoryResponse()
        assertEquals(categoryResponse.code, 200, "success")
        categoryResponse.code shouldEqual 200
        categoryResponse.result.size shouldEqual 4
        categoryResponse.message shouldEqual ""
    }
}