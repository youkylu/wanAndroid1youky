package com.wanAndroid.auth.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanAndroid.auth.usecase.DoLogin
import com.wanAndroid.auth.usecase.UpdateLoginState
import com.wanAndroid.auth.usecase.model.User
import com.wanAndroid.core.model.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
   private val  doLogin: DoLogin,
   private val updateLoginState: UpdateLoginState,
):ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun login(userName:String, password:String){
        viewModelScope.launch {
            val result = doLogin(userName, password)
            if (result is ApiResult.Success) {
                _user.postValue(result.data)
            } else {
                //fixme need show Error page
            }
        }
    }

    fun changeLoginState(isLogin:Boolean){
        viewModelScope.launch {
            updateLoginState(isLogin)
        }
    }
}