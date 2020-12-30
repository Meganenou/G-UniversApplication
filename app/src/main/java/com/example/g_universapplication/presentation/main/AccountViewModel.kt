package com.example.g_universapplication.presentation.main

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.g_universapplication.domain.entities.User
import com.example.g_universapplication.domain.usecase.CreateUserUseCase
import com.example.g_universapplication.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccountViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val accountliveData: MutableLiveData<AccountStatus> = MutableLiveData()

    fun onClickedAccount(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = User(emailUser, password)
            createUserUseCase.invoke(user)
            val accountStatus = if (user != null) {
                if (emailUser.isNotEmpty()) {
                    if (password.isNotEmpty()) {
                        AccountSuccess(user.email)
                    } else {
                        AccountPasswordMissing
                    }
                } else {
                    AccountMissing
                }
            } else {
                AccountError
            }
            withContext(Dispatchers.Main) {
                accountliveData.value = accountStatus
            }
        }
    }
}