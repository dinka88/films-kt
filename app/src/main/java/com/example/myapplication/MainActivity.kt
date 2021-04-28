package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        val search = findViewById<Button>(R.id.button1)

        search.setOnClickListener(View.OnClickListener { v ->
            Log.d("fff","bbb")

            val film = Data("Мстители", 2018)
            val copy = film.copy(name = "Другой фильм")
            Toast.makeText(applicationContext,film.name, Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext,copy.name, Toast.LENGTH_SHORT).show()
        })


    }

}