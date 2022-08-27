package com.wanAndroid.network.usecase

import retrofit2.Retrofit

interface NetworkService {

   fun getInstance(): Retrofit

   fun <T> create(service: Class<T>): T
}