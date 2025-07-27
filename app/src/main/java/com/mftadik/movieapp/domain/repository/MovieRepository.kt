package com.mftadik.movieapp.domain.repository

import com.mftadik.movieapp.data.remote.dto.MovieDetailDto
import com.mftadik.movieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}