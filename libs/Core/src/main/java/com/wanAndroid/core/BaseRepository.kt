package com.wanAndroid.core


import com.wanAndroid.core.model.ApiResult
import java.io.IOException

class BaseRepository {

    suspend fun <T : Any> apiCall(
        call: suspend () -> ApiResult<T>,
        errorMessage: String
    ): ApiResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            ApiResult.Error(IOException(errorMessage, e))
        }
    }
}