package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.MovieFragmentBinding
import com.example.myapplication.model.MovieDTO

class MovieFragment : Fragment() {
    private lateinit var binding : MovieFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= MovieFragmentBinding.inflate(inflater, container, false)
            return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        val observer = Observer<MovieDTO> { renderData (it) }
        viewModel.geteData().observe(viewLifecycleOwner, observer)
    }

    private fun renderData (data:MovieDTO){
        Log.d("rd", "rd") // TODO
    }
}