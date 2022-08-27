package com.wanAndroid.imageservice.usecase

import com.wanAndroid.imageservice.usecase.model.ImageRequest

interface ImageDataStore {
    fun loadImage(imageRequest: ImageRequest)
}