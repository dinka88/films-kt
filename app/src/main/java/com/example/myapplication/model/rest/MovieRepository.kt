package com.example.myapplication.model.rest

import com.example.myapplication.model.MovieDTO
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    val KEY = "ca12a3835303780bedf8aaa882c241fa"

    val api = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(
                    GsonConverterFactory.create(GsonBuilder().setLenient().create())
            ).build().create(MovieApi::class.java)

    fun loaderMovie(query: String, callback: Callback<MovieDTO>) {
        val movie = api.getMovie(KEY, query, 1, true, "ru-RU")
        movie.enqueue(callback)
    }
}