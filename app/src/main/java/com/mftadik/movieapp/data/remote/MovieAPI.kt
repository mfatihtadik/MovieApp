package com.mftadik.movieapp.data.remote

import com.mftadik.movieapp.data.remote.dto.MovieDetailDto
import com.mftadik.movieapp.data.remote.dto.MoviesDto
import com.mftadik.movieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto
}