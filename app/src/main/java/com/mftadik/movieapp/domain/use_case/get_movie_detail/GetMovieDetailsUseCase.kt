package com.mftadik.movieapp.domain.use_case.get_movie_detail

import coil.network.HttpException
import com.mftadik.movieapp.data.remote.dto.toMovieDetail
import com.mftadik.movieapp.domain.model.MovieDetail
import com.mftadik.movieapp.domain.repository.MovieRepository
import com.mftadik.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            if (movieDetail.Response.equals("True")) {
                emit(Resource.Success(movieDetail.toMovieDetail()))
            } else {
                emit(Resource.Error("No Data!"))
            }
        } catch (e: IOError) {
            emit(Resource.Error(message = "No Internet Connection"))
        } catch (e : HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}