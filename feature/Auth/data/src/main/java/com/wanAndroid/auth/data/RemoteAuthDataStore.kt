package com.wanAndroid.auth.data

import com.wanAndroid.auth.usecase.AuthDataStore
import com.wanAndroid.auth.usecase.model.User
import com.wanAndroid.core.model.ApiResult
import com.wanAndroid.datastore.usecase.DataStoreManager
import com.wanAndroid.network.usecase.GetNetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RemoteAuthDataStore(
    private val dataStoreManager: DataStoreManager,
    private val getNetworkService: GetNetworkService
) : AuthDataStore {

    private val service by lazy {
        getNetworkService().create(AuthApiService::class.java)
    }

    override suspend fun isLoginDataSaved(): Boolean {
        val userName = dataStoreManager.getValue(KEY_USER_NAME, "")
        return  userName.isNotEmpty()
    }

    override suspend fun login(userName: String, password: String): ApiResult<User> {
        return withContext(Dispatchers.IO) {
            val response = service.login(userName, password)
            if (response.errorCode != 0) {
                ApiResult.Error(Exception(response.errorMsg))
            } else {
                if (response.data.username.isNotEmpty()) {
                    saveLoginData(response.data)
                    ApiResult.Success(response.data)
                } else {
                    ApiResult.Error(Exception("Login Failed"))
                }
            }
        }
    }

    override suspend fun logout() : ApiResult<Boolean>{
        return withContext(Dispatchers.IO) {
            val response = service.logOut()
            if (response.errorCode != 0) {
                ApiResult.Error(Exception(response.errorMsg))
            } else {
                    dataStoreManager.setValue(KEY_USER_NAME, "")
                    dataStoreManager.setValue(KEY_TOKEN, "")
                    dataStoreManager.setValue(KEY_PASSWORD, "")
                    dataStoreManager.setValue(KEY_IS_LOGIN, false)
                    ApiResult.Success(true)
            }
        }
    }

    override suspend fun saveLoginData(user: User) {
        withContext(Dispatchers.IO) {
            dataStoreManager.setValue(KEY_USER_NAME, user.username)
            dataStoreManager.setValue(KEY_TOKEN, user.token)
            dataStoreManager.setValue(KEY_PASSWORD, user.password)
        }
    }

    override suspend fun updateLoginState(isLogin: Boolean) {
        withContext(Dispatchers.IO) {
            dataStoreManager.setValue(KEY_IS_LOGIN, isLogin)
        }
    }

    override suspend fun getLoginState(): Flow<Boolean> {
        return dataStoreManager.getValueFlow(KEY_IS_LOGIN, false)
    }
}

internal const val KEY_USER_NAME = "USER_NAME"
internal const val KEY_TOKEN = "TOKEN"
internal const val KEY_PASSWORD = "PASSWORD"
internal const val KEY_IS_LOGIN = "IS_LOGIN"