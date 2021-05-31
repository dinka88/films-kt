package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.SettingFragmentBinding


class Settings2Activity : AppCompatActivity() {
    private lateinit var binding: SettingFragmentBinding
    val ADULT_KEY = "ADULT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SettingFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val current = sharedPreferences.getBoolean(ADULT_KEY, true)

        Log.i("","Current adult value is $current")

        binding.adult.setChecked(current)
        binding.adult.setOnCheckedChangeListener { buttonView, isCheched ->
            val edit = sharedPreferences.edit()
            edit.putBoolean(ADULT_KEY, isCheched)
            edit.commit()
        }
    }

}