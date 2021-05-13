package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.MovieDTO
import com.example.myapplication.model.MovieRepository
import com.example.myapplication.model.Repository

class MainViewModel(private val liveDataToObserver: MutableLiveData<MovieDTO> = MutableLiveData()): ViewModel() {

    val movieRepository: Repository = MovieRepository()

    fun geteData (): LiveData<MovieDTO>{
        Thread {
            val dto = movieRepository.find("П") // TODO
            liveDataToObserver.postValue(dto)
        }.start()
        return liveDataToObserver
    }
}