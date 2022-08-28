package com.wanAndroid.auth.data.di

import com.wanAndroid.auth.data.RemoteAuthDataStore
import com.wanAndroid.auth.usecase.AuthDataStore
import com.wanAndroid.datastore.usecase.DataStoreManager
import com.wanAndroid.network.usecase.GetNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthDataStoreModule {

    @Provides
    fun provideAuthDataStore(
        getNetworkService: GetNetworkService,
        dataStoreManager: DataStoreManager
    ): AuthDataStore = RemoteAuthDataStore(dataStoreManager, getNetworkService)
}