package com.wanAndroid.imageservice.usecase

import com.wanAndroid.imageservice.usecase.model.ImageRequest
import javax.inject.Inject
import android.content.Context
import android.widget.ImageView


class GetImageService @Inject constructor(
    private val imageDataStore: ImageDataStore
) {
    operator fun invoke(context: Context, imageRequest: ImageRequest, target: ImageView) {
        imageDataStore.loadImage(imageRequest)
    }
}