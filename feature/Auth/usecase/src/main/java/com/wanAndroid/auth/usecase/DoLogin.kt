package com.wanAndroid.auth.usecase

import com.wanAndroid.auth.usecase.model.User
import com.wanAndroid.core.model.ApiResult
import javax.inject.Inject

class DoLogin @Inject constructor(
  private val authDataStore: AuthDataStore
) {
    suspend operator fun invoke(userName:String, password:String):ApiResult<User>{
       return authDataStore.login(userName, password)
    }
}