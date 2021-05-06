package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val searchFragment = FragmentSearch()
        searchFragment.setArguments(intent.extras)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_search, searchFragment).commit()
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }


}