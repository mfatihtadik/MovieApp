package com.mftadik.movieapp.domain.use_case.get_movies

import coil.network.HttpException
import com.mftadik.movieapp.data.remote.dto.ToMovieList
import com.mftadik.movieapp.domain.model.Movie
import com.mftadik.movieapp.domain.repository.MovieRepository
import com.mftadik.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.ToMovieList()))
            } else {
                emit(Resource.Error("No Movie Found!"))
            }
        } catch (e:IOError) {
            emit(Resource.Error("No Internet Connection"))

        } catch (e : HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}