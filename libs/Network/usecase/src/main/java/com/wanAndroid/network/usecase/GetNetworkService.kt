package com.wanAndroid.network.usecase

import retrofit2.Retrofit
import javax.inject.Inject

class GetNetworkService @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke():Retrofit =
        networkService.getInstance()

}