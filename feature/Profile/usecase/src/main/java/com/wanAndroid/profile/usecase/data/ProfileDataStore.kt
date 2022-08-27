package com.wanAndroid.profile.usecase.data

import com.wanAndroid.core.model.ApiResult

interface ProfileDataStore {

    suspend fun getPhoto(): ApiResult<String>

}