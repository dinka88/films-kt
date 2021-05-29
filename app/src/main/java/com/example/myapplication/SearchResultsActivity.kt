package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.SearchResultsActivityBinding


class SearchResultsActivity : AppCompatActivity() {
    private lateinit var binding: SearchResultsActivityBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= SearchResultsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieFragment = MovieFragment()
        movieFragment.setArguments(intent.extras)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_movie, movieFragment).commit()
        val searchFragment = SearchFragment()
//        searchFragment.setArguments(intent.extras)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_search, searchFragment).commit()
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }
}