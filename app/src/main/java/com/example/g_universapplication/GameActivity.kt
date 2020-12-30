package com.example.g_universapplication

import android.os.Bundle
import android.util.Log.d
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_game.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(findViewById(R.id.toolbar))

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIService::class.java)

        api.fectAllGames().enqueue(object : Callback<List<Game>> {
            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                d("oui", "Failure")
            }

            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                showData(response.body()!!)
            }
        })
    }

    private fun showData(games: List<Game>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@GameActivity)
            adapter = GamesAdapter(games)
        }
    }
}