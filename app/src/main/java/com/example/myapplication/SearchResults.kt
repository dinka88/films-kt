package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.SearchResultsBinding

class SearchResults : AppCompatActivity() {
    private lateinit var binding: SearchResultsBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= SearchResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieFragment = FragmentMovie()
        movieFragment.setArguments(intent.extras)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_movie, movieFragment).commit()
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }
}