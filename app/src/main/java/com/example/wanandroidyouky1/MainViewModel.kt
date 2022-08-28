package com.example.wanandroidyouky1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanAndroid.auth.usecase.GetLoginState
import com.wanAndroid.auth.usecase.IsLoginDataSaved
import com.wanAndroid.auth.usecase.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val isLoginDataSaved: IsLoginDataSaved,
    private val getLoginState: GetLoginState,
) : ViewModel() {
    var loginDataSaved: MutableStateFlow<Boolean> = MutableStateFlow(false)

    lateinit var loginStateFlow: StateFlow<Boolean>
        private set

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean>
        get() = _loginState

    init {
        viewModelScope.launch {
            loginStateFlow = getLoginState().stateIn(this)
            loginStateFlow.collect{
                _loginState.postValue(it)
            }
        }
        viewModelScope.launch {
            loginDataSaved.emit(isLoginDataSaved())
        }
    }


}