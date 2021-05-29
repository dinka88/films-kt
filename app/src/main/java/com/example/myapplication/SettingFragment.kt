package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.MovieFragmentBinding
import com.example.myapplication.databinding.SearchFragmentBinding

class SettingFragment: Fragment() {
    private lateinit var binding : SearchFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}