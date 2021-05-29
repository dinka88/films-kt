package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.InfoMovieActivityBinding

class InfoMovieActivity : AppCompatActivity() {
    private lateinit var binding: InfoMovieActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InfoMovieActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}