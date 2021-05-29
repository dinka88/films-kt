package com.example.myapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MovieInfoEntity::class), version = 1, exportSchema = false)
abstract class MovieInfoRoomDatabase : RoomDatabase() {

    abstract fun movieInfoDao(): MovieInfoDao

    companion object {
        @Volatile
        private var INSTANCE: MovieInfoRoomDatabase? = null

        fun getDatabase(context: Context): MovieInfoRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieInfoRoomDatabase::class.java,
                        "movie_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}