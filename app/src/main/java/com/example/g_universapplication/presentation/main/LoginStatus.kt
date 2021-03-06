package com.example.g_universapplication.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()
object LoginWrongPassword : LoginStatus()
object LoginNonexistent : LoginStatus()
