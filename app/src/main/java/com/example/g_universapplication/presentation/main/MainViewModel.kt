package com.example.g_universapplication.presentation.main

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun onClickedSignIn(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user: User? = getUserUseCase.invoke(emailUser, password)
            val loginStatus = if (user != null) {
                if(emailUser.equals(user.email) && emailUser.isNotEmpty()){
                    if(password!=user.password){
                        LoginWrongPassword
                    }else{
                        LoginSuccess(user.email)
                    }
                }else{
                    LoginNonexistent
                }
            }else{
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginliveData.value = loginStatus
            }
        }
    }

    fun onClickAccount(activity: Activity) {
        viewModelScope.launch(Dispatchers.IO){
            val intent = Intent(activity, AccountActivity::class.java)
            startActivity(activity,intent,null)
        }
    }

    fun onClickSignIn(activity: Activity) {
        viewModelScope.launch(Dispatchers.IO){
            val intent = Intent(activity, GameActivity::class.java)
            startActivity(activity,intent,null);
        }
    }
}