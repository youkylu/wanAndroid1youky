package com.wanAndroid.profile.view

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.wanAndroid.imageservice.usecase.GetImageService
import com.wanAndroid.imageservice.usecase.model.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getImageService: GetImageService
):ViewModel(){


    fun loadImage(context:Context, imageRequest: ImageRequest, target:ImageView){
        getImageService(context, imageRequest, target)
    }
}