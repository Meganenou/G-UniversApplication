package com.example.g_universapplication.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.g_universapplication.GameActivity
import com.example.g_universapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginliveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    //TODO()
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Compte inconnu")
                        .setPositiveButton("OK") {dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        account.setOnClickListener {
            mainViewModel.onClickedAccount(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        signIN.setOnClickListener {
            mainViewModel.onClickSignIn(this)
        }
    }
}