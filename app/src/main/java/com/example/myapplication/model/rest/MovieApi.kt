package com.example.myapplication.model.rest

import com.example.myapplication.model.MovieDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET ("search/movie")
    fun getMovie (@Query("api_key") apiKey: String,
                  @Query("query") query: String,
                  @Query("page") page: Int,
                  @Query("include_adult") includeAdult: Boolean,
                  @Query("language") lang: String): Call<MovieDTO>
}