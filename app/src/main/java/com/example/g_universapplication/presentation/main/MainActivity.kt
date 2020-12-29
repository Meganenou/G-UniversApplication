package com.example.g_universapplication.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.g_universapplication.R
import com.example.g_universapplication.presentation.main.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signIN.setOnClickListener {
            mainViewModel.onClickedUser("")
        }
    }
}