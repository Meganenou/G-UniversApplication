package com.example.g_universapplication.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.g_universapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_account.*
import org.koin.android.ext.android.inject

class AccountActivity : AppCompatActivity() {

    val accountViewModel: AccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        accountViewModel.accountliveData.observe(this, Observer {
            when(it){
                is AccountSuccess -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    val t = Toast.makeText(this, "Bienvenue !", Toast.LENGTH_SHORT)
                        t.show()
                }
                AccountError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Il faut saisir du texte dans les deux champs")
                        .setPositiveButton("OK"){ dialog, which -> dialog.dismiss()
                        }
                        .show()
                }
                AccountMissing -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Entrez un email")
                        .setPositiveButton("OK"){ dialog, which -> dialog.dismiss()
                        }
                        .show()
                }
                AccountPasswordMissing -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Entrez un password")
                        .setPositiveButton("OK"){ dialog, which -> dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        signUP.setOnClickListener {
            accountViewModel.onClickedAccount(login_edit.text.toString().trim(), password_edit.text.toString())
        }
    }
}