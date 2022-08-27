package com.wanAndroid.profile.usecase

import com.wanAndroid.core.model.ApiResult
import com.wanAndroid.profile.usecase.data.ProfileDataStore
import javax.inject.Inject

class LoadBannerPic @Inject constructor(
    @JvmSuppressWildcards private val profileDataStore:ProfileDataStore
){
    suspend operator fun invoke():ApiResult<String>{
      return  profileDataStore.getPhoto()
    }
}