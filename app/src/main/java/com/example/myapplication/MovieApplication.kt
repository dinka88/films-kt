package com.example.myapplication

import android.app.Application
import com.example.myapplication.dao.MovieInfoRoomDatabase
import com.example.myapplication.model.rest.MovieRepository

class MovieApplication : Application() {
    val database by lazy { MovieInfoRoomDatabase.getDatabase(this) }
    val repository by lazy { MovieRepository(database.movieInfoDao()) }
}