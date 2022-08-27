package com.wanAndroid.datastore.data.di

import android.content.Context
import com.wanAndroid.datastore.data.DataStoreManagerImpl
import com.wanAndroid.datastore.usecase.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataStoreManagerModule {

    @Provides
    fun provideImageService(
        @ApplicationContext context: Context
    ): DataStoreManager = DataStoreManagerImpl(context)
}