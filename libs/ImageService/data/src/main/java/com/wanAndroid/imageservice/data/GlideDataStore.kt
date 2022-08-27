package com.wanAndroid.imageservice.data

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.wanAndroid.imageservice.usecase.model.ImageRequest
import com.wanAndroid.imageservice.usecase.ImageDataStore

class GlideDataStore:ImageDataStore {

    override fun loadImage(context: Context, imageRequest: ImageRequest, target: ImageView) {
        if(imageRequest.url.isNotEmpty()){
            Glide.with(context).load(imageRequest.url).into(target)
        }
    }
}