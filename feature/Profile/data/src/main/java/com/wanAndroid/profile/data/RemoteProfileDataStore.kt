package com.wanAndroid.profile.data

import com.wanAndroid.core.model.ApiResult
import com.wanAndroid.network.usecase.GetNetworkService
import com.wanAndroid.profile.usecase.data.ProfileDataStore
import com.wanAndroid.profile.usecase.model.BannerData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class RemoteProfileDataStore(
    private val getNetworkService: GetNetworkService
) : ProfileDataStore {

    private val service by lazy {
        getNetworkService().create(ProfileApiService::class.java)
    }

    override suspend fun getPhoto(): ApiResult<String> {
        return withContext(Dispatchers.IO) {
            if (service.getBanner().errorCode != 0) {
                ApiResult.Error(Exception(service.getBanner().errorMsg))
            } else {
                if(service.getBanner().data.size>1 && service.getBanner().data[0].imagePath.isNotEmpty()){
                    ApiResult.Success(service.getBanner().data[0].imagePath)
                }else{
                    ApiResult.Error(Exception("No image path"))
                }
            }
        }
    }
}