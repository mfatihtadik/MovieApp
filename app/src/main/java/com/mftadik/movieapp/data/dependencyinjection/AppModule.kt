package com.mftadik.movieapp.data.dependencyinjection

import com.mftadik.movieapp.data.remote.MovieAPI
import com.mftadik.movieapp.data.repository.MovieRepositoryImpl
import com.mftadik.movieapp.domain.repository.MovieRepository
import com.mftadik.movieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieApi() : MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(api: MovieAPI) : MovieRepository {
        return MovieRepositoryImpl(api)
    }
}