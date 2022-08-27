package com.wanAndroid.imageservice.data.di

import com.wanAndroid.imageservice.data.GlideDataStore
import com.wanAndroid.imageservice.usecase.ImageDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ImageServiceModule {

    @Provides
    fun provideImageService(): ImageDataStore = GlideDataStore()
}