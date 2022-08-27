package com.wanAndroid.network.data

import com.wanAndroid.network.data.util.CommonInterceptor
import com.wanAndroid.network.usecase.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class RetrofitService:NetworkService {

    private val retrofit: Retrofit

    companion object {
        val instance: RetrofitService by lazy { RetrofitService() }
    }

    init {
        retrofit = Retrofit.Builder()
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.wanandroid.com")
            .build()
    }



    override fun getInstance() :Retrofit = retrofit

    private fun initClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(initLogInterceptor())
            .addInterceptor(CommonInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }

    override fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}