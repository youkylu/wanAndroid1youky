package com.wanAndroid.profile.data

import com.wanAndroid.core.model.ApiResponse
import com.wanAndroid.profile.usecase.model.BannerData
import retrofit2.http.GET

interface ProfileApiService {

    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<List<BannerData>>
}