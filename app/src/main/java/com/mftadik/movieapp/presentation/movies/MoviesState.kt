package com.mftadik.movieapp.presentation.movies

import com.mftadik.movieapp.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "Batman"
)
