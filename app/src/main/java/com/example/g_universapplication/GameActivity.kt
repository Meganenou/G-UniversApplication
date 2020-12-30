package com.example.g_universapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_game.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameActivity : AppCompatActivity(), GamesAdapter.OnGameItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(findViewById(R.id.toolbar))

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
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

        //createGameList()

    }

    private fun showData(games: List<Game>) {
        recyclerView.apply {
            var gameAdapter = GamesAdapter(games,this@GameActivity)
            recyclerView.layoutManager = LinearLayoutManager(this@GameActivity)
            recyclerView.adapter = gameAdapter
        }
    }

    override fun onItemClic(game: Game, position: Int) {
        Toast.makeText(this, "Going to "+game.name,Toast.LENGTH_LONG).show()
        val intent = Intent(this, Description::class.java)
        intent.putExtra("landscape", game.landscape)
        intent.putExtra("univers", game.univers)
        intent.putExtra("logo", game.logo)

        startActivity(intent)
    }

}

