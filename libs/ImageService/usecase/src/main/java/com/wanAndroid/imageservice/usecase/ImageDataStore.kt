package com.wanAndroid.imageservice.usecase

import android.content.Context
import android.widget.ImageView
import com.wanAndroid.imageservice.usecase.model.ImageRequest

interface ImageDataStore {
    fun loadImage(context: Context, imageRequest: ImageRequest, target: ImageView)
}