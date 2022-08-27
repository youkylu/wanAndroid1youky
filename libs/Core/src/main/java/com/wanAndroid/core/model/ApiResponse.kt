package com.wanAndroid.core.model

data class ApiResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)