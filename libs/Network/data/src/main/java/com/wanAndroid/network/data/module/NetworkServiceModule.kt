package com.wanAndroid.network.data.module

import com.wanAndroid.network.data.RetrofitService
import com.wanAndroid.network.usecase.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NetworkServiceModule {


    @Provides
    fun provideNetworkService():NetworkService = RetrofitService()
}