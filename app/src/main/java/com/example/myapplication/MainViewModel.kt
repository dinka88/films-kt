package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.MovieDTO
import com.example.myapplication.model.rest.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val liveDataToObserver: MutableLiveData<MovieDTO> = MutableLiveData()): ViewModel() {

    private val callBack = object : Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            liveDataToObserver.postValue(serverResponse!!)
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            t.printStackTrace()
            Log.e("ERROR", "Not found")
        }
    }

    fun getData(query: String): LiveData<MovieDTO>{
        MovieRepository.loaderMovie(query, callBack)
        return liveDataToObserver
    }
}