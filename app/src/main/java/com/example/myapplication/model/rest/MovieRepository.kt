package com.example.myapplication.model.rest

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.dao.MovieInfoDao
import com.example.myapplication.dao.MovieInfoEntity
import com.example.myapplication.dao.MovieInfoRoomDatabase
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDTO
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.Future

class MovieRepository(val dao: MovieInfoDao) {
    val KEY = "ca12a3835303780bedf8aaa882c241fa"

    val api = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(
                    GsonConverterFactory.create(GsonBuilder().setLenient().create())
            ).build().create(MovieApi::class.java)

    val executor = Executors.newFixedThreadPool(10)

    @WorkerThread
    fun getViewedState(movie: Movie): LiveData<MovieInfoEntity> {
        return dao.findById(movie.id)
    }

    fun changeViewedState(movie: Movie, viewed: Boolean): Future<*>? {
        return executor.submit {
            dao.insert(MovieInfoEntity(movie.id, viewed))
        }
    }

    fun loaderMovie(query: String, adult: Boolean, callback: Callback<MovieDTO>) {
        val movie = api.getMovie(KEY, query, 1, adult, "ru-RU")
        movie.enqueue(callback)
    }
}