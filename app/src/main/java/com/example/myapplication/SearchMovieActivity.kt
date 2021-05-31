package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.SearchMovieActivityBinding

class SearchMovieActivity : AppCompatActivity() {

    private lateinit var binding: SearchMovieActivityBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchMovieActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val searchFragment = SearchFragment()
        searchFragment.setArguments(intent.extras)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_search, searchFragment).commit()
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        viewModel.repository = (application as MovieApplication).repository
    }


}