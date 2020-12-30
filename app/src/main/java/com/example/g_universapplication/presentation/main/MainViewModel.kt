package com.example.g_universapplication.presentation.main

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.g_universapplication.GameActivity
import com.example.g_universapplication.domain.entities.User
import com.example.g_universapplication.domain.usecase.CreateUserUseCase
import com.example.g_universapplication.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val loginliveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedAccount(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user: User? = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null) {
                LoginSuccess(user.email)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginliveData.value = loginStatus
            }
        }
    }

    fun onClickSignIn(activity: Activity) {
        viewModelScope.launch(Dispatchers.IO){
            val intent = Intent(activity, GameActivity::class.java)
            startActivity(activity,intent,null);
        }
    }
}