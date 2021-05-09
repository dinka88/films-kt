package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val liveDataToObserver: MutableLiveData<Any> = MutableLiveData()): ViewModel() {
    fun geteData (): LiveData<Any>{
        return liveDataToObserver
    }
}