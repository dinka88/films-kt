package com.example.myapplication.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_info")
data class MovieInfoEntity(@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                           @ColumnInfo(name = "viewed") val viewed: Boolean)
