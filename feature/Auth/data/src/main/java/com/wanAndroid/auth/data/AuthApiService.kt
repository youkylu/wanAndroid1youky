package com.wanAndroid.auth.data

import com.wanAndroid.auth.usecase.model.User
import com.wanAndroid.core.model.ApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): ApiResponse<User>

    @GET("/user/logout/json")
    suspend fun logOut(): ApiResponse<Any>

}