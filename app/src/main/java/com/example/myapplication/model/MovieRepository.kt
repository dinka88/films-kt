package com.example.myapplication.model

class MovieRepository : Repository {

    private val movieLoader: MovieLoader = MovieLoader()

//    override fun getDataFromServer()= Movie ("Name")
//    override fun getDataFromLocalStorage()= Movie ("Name")
    override fun find(query: String): MovieDTO? {
        return movieLoader.loaderMovie(query)
    }
}