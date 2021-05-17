package com.example.myapplication.model

data class MovieDTO(
        val page: Int?,
        val results: List<Movie>,
        val total_pages: Int?,
        val total_results: Int?
)
