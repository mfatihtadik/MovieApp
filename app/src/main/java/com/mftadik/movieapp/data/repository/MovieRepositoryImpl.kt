package com.mftadik.movieapp.data.repository

import com.mftadik.movieapp.data.remote.MovieAPI
import com.mftadik.movieapp.data.remote.dto.MovieDetailDto
import com.mftadik.movieapp.data.remote.dto.MoviesDto
import com.mftadik.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI) : MovieRepository {

    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}