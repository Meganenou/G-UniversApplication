package com.example.g_universapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*

class Description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        univers.text = getIntent().getStringExtra("univers")

        Picasso.get().load(getIntent().getStringExtra("logo")).into(logo)

    }
}