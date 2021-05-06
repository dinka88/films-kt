package com.example.myapplication.model

class MovieRepository : Repository {
    override fun getDataFromServer()= Movie ("Name")
    override fun getDataFromLocalStorage()= Movie ("Name")
}