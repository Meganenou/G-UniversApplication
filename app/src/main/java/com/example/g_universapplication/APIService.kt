package com.example.g_universapplication

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/Meganenou/G-UniversApplication/master/API.json")
    fun fectAllGames():Call<List<Game>>
}