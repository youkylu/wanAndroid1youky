package com.wanAndroid.profile.data.di

import com.wanAndroid.network.usecase.GetNetworkService
import com.wanAndroid.profile.data.RemoteProfileDataStore
import com.wanAndroid.profile.usecase.data.ProfileDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    @Provides
    fun provideProfile(
        getNetworkService: GetNetworkService
    ): ProfileDataStore = RemoteProfileDataStore(getNetworkService)
}