package com.wanAndroid.profile.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanAndroid.core.model.ApiResult
import com.wanAndroid.profile.usecase.LoadBannerPic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val loadBannerPic: LoadBannerPic,
) : ViewModel() {
    private val _banner = MutableLiveData<String>()
    val banner: LiveData<String>
        get() = _banner

    fun getPhoto() {
        viewModelScope.launch {
            val path = loadBannerPic()
            if (path is ApiResult.Success) {
                _banner.postValue(path.data)
            } else {
                //fixme need show Error page
            }

        }
    }

    fun loadPic() {
//        getImageService(it, ImageRequest(url = path), binding.banner)
    }


}