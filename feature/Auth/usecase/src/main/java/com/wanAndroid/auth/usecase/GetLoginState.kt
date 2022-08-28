package com.wanAndroid.auth.usecase

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLoginState @Inject constructor(
    private val authDataStore: AuthDataStore
) {
    suspend operator fun invoke(): Flow<Boolean> =
        authDataStore.getLoginState()

}