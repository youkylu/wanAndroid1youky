package com.wanAndroid.auth.usecase

import javax.inject.Inject

class IsLoginDataSaved @Inject constructor(
    private val authDataStore: AuthDataStore
) {
    suspend operator fun invoke(): Boolean {
        return authDataStore.isLoginDataSaved()
    }
}