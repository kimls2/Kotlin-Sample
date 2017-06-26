package com.qualson.tubing

import com.nhaarman.mockito_kotlin.verify
import com.qualson.tubing.data.DataManager
import com.qualson.tubing.ui.main.MainMvpView
import com.qualson.tubing.ui.main.MainPresenter
import com.qualson.tubing.util.RxSchedulersOverrideRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by ykim on 2017. 4. 20..
 */
@RunWith(MockitoJUnitRunner::class) class MainPresenterTest {

    @JvmField @Rule val mOverrideSchedulersRule = RxSchedulersOverrideRule()

    @Mock lateinit var mMockMainMvpView: MainMvpView
    @Mock lateinit var mMockDataManager: DataManager
    @InjectMocks lateinit var mMainPresenter: MainPresenter

    @Before fun setUp() {
        mMainPresenter.attachView(mMockMainMvpView)
    }

    @After fun detachView() {
        mMainPresenter.detachView()
    }

    @Test fun loadCategoriesSuccessful() {
//        val channelList = MockModelFabric.newChannelList(4)
////        doReturn(Observable.just(channelList)).`whenever`(mMockDataManager.getCategory())
//        whenever(mMockDataManager.getCategory()).thenReturn(Observable.just(channelList))

//        mMainPresenter.loadCategory()
        verify(mMockMainMvpView).showLoading(true)
//        verify(mMockMainMvpView).showCategories(channelList)
        verify(mMockMainMvpView).showLoading(false)

    }

    @Test fun loadCategoryFail() {
//        whenever(mMockDataManager.getCategory()).thenReturn(Observable.error<MutableList<Channel>>(NullPointerException()))
//        mMainPresenter.loadCategory()
    }
}


