package com.wanAndroid.auth.usecase

import com.wanAndroid.core.model.ApiResult
import javax.inject.Inject

class DoLogout @Inject constructor(
    private val authDataStore: AuthDataStore
) {
    suspend operator fun invoke(): ApiResult<Boolean>  =
        authDataStore.logout()

}