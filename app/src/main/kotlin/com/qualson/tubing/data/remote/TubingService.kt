package com.qualson.tubing.data.remote

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.qualson.tubing.BuildConfig
import com.qualson.tubing.Constants
import com.qualson.tubing.data.model.CategoryResponse
import com.qualson.tubing.data.model.menu.MenuResponse
import com.qualson.tubing.data.model.user.User
import com.qualson.tubing.data.model.user.UserUpdateResponse
import io.reactivex.Completable
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by ykim on 2017. 4. 18..
 */

interface TubingService {

    @GET("/categoryLabels")
    fun getCategory(): Observable<CategoryResponse>

    @POST("/user/appInstall")
    fun appInstall(@Body body: Map<String, String>): Completable

    @GET("/api/menu")
    fun getMenu(@Header("authKey") cookieString: String,
                @Query("preferredLanguage") preferredLanguage: String): Observable<MenuResponse>

    @POST("/api/user/update")
    fun userUpdate(@Header("authKey") authKey: String,
                   @Body userBody: User): Observable<UserUpdateResponse>

    @Multipart @POST("/user/upload")
    fun imageUpload(
            @Part imageFile: MultipartBody.Part): Observable<UserUpdateResponse>

    @POST("/api/user/leave")
    fun leave(@Header("authKey") loginKey: String): Completable

    @POST("/api/push/{type}")
    fun setPush(@Header("authKey") authKey: String,
                @Path("type") type: String): Completable


    object Factory {
        @JvmStatic fun makeSuperFanService(): TubingService {
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor() //
                            .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                    .addNetworkInterceptor(if (BuildConfig.DEBUG) StethoInterceptor() else null)
                    .build()

            val gSon: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(Constants.TUBING_URL_BASE)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gSon))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(TubingService::class.java)
        }
    }
}