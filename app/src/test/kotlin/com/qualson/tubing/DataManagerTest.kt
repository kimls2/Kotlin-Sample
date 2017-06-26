package com.qualson.tubing

import com.nhaarman.mockito_kotlin.doReturn
import com.qualson.tubing.data.DataManager
import com.qualson.tubing.data.local.PreferenceHelper
import com.qualson.tubing.data.model.Channel
import com.qualson.tubing.data.remote.TubingService
import com.qualson.tubing.test.common.MockModelFabric
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by ykim on 2017. 4. 20..
 */
@RunWith(MockitoJUnitRunner::class) class DataManagerTest {

    @Mock lateinit var mMockTubingService: TubingService
    @Mock lateinit var mMockPreferencesHelper: PreferenceHelper
    @InjectMocks lateinit var mDataManager: DataManager

    @Test fun getCategory() {
        val categoryResponse = MockModelFabric.newCategoryResponse()
        doReturn(Observable.just(categoryResponse)).`when`(mMockTubingService).getCategory()

        val testObserver = TestObserver<MutableList<Channel>>()
        mDataManager.getCategory().subscribe(testObserver)
        testObserver.assertValue(categoryResponse.result)
        testObserver.assertValueCount(1)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

}