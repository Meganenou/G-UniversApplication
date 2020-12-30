package com.example.g_universapplication.presentation.main

sealed class AccountStatus

data class AccountSuccess(val email:String):AccountStatus()
object AccountExisted: AccountStatus()
object AccountMissing: AccountStatus()
object AccountPasswordMissing : AccountStatus()
object AccountError : AccountStatus()