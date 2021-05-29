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
import com.example.myapplication.model.Movie
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
        val query = arguments?.getString("query")
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

        val observer = Observer<MovieDTO> { renderData (it) }
        viewModel.getData(query!!).observe(viewLifecycleOwner, observer)
    }

    private fun renderData (data: MovieDTO) {
        Log.d("rd", "rd") // TODO
        if(data.results.isNotEmpty()) {
            renderFirst(data.results.first())
        }
    }

    private fun renderFirst(movie: Movie) {
        binding.nameMovie.setText(movie.title)
        binding.descriptionMovie.setText(movie.overview)
        binding.yearMovie.setText(movie.release_date)
        val posterPrefix = "https://image.tmdb.org/t/p/w500"
        val posterUrl = posterPrefix + movie.poster_path
    }
}