package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieInfoDao {

    @Query("SELECT * FROM movie_info WHERE id=:id ")
    fun findById(id: Int): LiveData<MovieInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieInfo: MovieInfoEntity)
}