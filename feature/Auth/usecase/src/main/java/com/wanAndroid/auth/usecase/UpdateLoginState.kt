package com.wanAndroid.auth.usecase

import javax.inject.Inject

class UpdateLoginState @Inject constructor(
    private val authDataStore: AuthDataStore
) {
    suspend operator fun invoke(isLogin: Boolean) {
        authDataStore.updateLoginState(isLogin)
    }
}