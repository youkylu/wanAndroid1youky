package com.wanAndroid.auth.usecase

import com.wanAndroid.auth.usecase.model.User
import com.wanAndroid.core.model.ApiResult
import kotlinx.coroutines.flow.Flow

interface AuthDataStore {

    suspend fun isLoginDataSaved(): Boolean

    suspend fun login(userName: String, password: String): ApiResult<User>

    suspend fun logout(): ApiResult<Boolean>

    suspend fun saveLoginData(user: User)

    suspend fun updateLoginState(isLogin:Boolean)

    suspend fun getLoginState() : Flow<Boolean>
}