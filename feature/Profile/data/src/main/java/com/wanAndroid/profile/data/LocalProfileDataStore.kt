package com.wanAndroid.profile.data

import com.wanAndroid.core.model.ApiResult
import com.wanAndroid.profile.usecase.data.ProfileDataStore


class LocalProfileDataStore : ProfileDataStore {
    override suspend fun getPhoto(): ApiResult<String> {
        TODO("Not yet implemented")
    }

}