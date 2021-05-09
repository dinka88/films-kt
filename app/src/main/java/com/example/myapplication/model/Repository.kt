package com.example.myapplication.model

interface Repository {
    fun getDataFromServer () : Movie
    fun getDataFromLocalStorage(): Movie
}