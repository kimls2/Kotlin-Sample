package com.qualson.tubing.data

import com.qualson.tubing.data.local.PreferenceHelper
import com.qualson.tubing.data.model.Channel
import com.qualson.tubing.data.model.menu.MenuResponse
import com.qualson.tubing.data.model.user.User
import com.qualson.tubing.data.model.user.UserUpdateResponse
import com.qualson.tubing.data.remote.TubingService
import io.reactivex.Completable
import io.reactivex.Observable
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ykim on 2017. 4. 18..
 */

@Singleton open class DataManager @Inject constructor(private val tubingService: TubingService,
                                                      private val preferenceHelper: PreferenceHelper) {

    fun getPreferenceHelper(): PreferenceHelper {
        return preferenceHelper
    }

    fun getCategory(): Observable<MutableList<Channel>> {
        return tubingService.getCategory()
                .filter { (_, code) -> code == 200 }
                .map { (_, _, result) -> result }
    }

    fun appInstall(body: Map<String, String>): Completable {
        return tubingService.appInstall(body)
    }

    fun getMenu(): Observable<MenuResponse> {
        return tubingService.getMenu(getPreferenceHelper().getLoginKey(),
                getPreferenceHelper().getPrefLang())
    }

    fun userUpdate(userBody: User): Observable<UserUpdateResponse> {
        return tubingService.userUpdate(getPreferenceHelper().getLoginKey(), userBody)
                .doOnNext({ userUpdateResponse ->
                    getPreferenceHelper().putLoginKey(
                            userUpdateResponse.result)
                })
    }

    fun imageUpload(imageFile: MultipartBody.Part): Observable<UserUpdateResponse> {
        return tubingService.imageUpload(imageFile)
    }

    fun leave(): Completable {
        return tubingService.leave(getPreferenceHelper().getLoginKey())
                .doOnComplete({ getPreferenceHelper().clear() })
    }

    fun setPush(on: Boolean): Completable {
        var pushType = "ON"
        if (!on) {
            pushType = "OFF"
        }
        return tubingService.setPush(getPreferenceHelper().getLoginKey(), pushType)
    }
}
