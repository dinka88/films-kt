package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.SearchFragmentBinding
import java.util.concurrent.Executors


class SearchFragment: Fragment() {
    private lateinit var binding: SearchFragmentBinding

    val executor = Executors.newScheduledThreadPool(1)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SearchFragmentBinding.inflate(inflater,container, false)
        return binding.root


    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSearch.setOnClickListener({ view ->
//            view.showSnackBar(R.string.search)
//            executor.schedule({
            val adult = view.context.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE).getBoolean("ADULT", true)

            val intent = Intent(view.context, SearchResultsActivity::class.java)
                intent.putExtra("query", binding.inputSearch.text.toString())
                intent.putExtra("adult", adult)
                startActivity(intent)
//            }, 1, TimeUnit.SECONDS)
//           textSearch.toString()
        })
    }
}