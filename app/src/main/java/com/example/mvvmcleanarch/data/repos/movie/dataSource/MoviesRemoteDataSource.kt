package com.example.mvvmcleanarch.data.repos.movie.dataSource

import com.example.mvvmcleanarch.data.model.movie.MovieList
import retrofit2.Response

interface MoviesRemoteDataSource {
    suspend fun getPopularMovies(): Response<MovieList>
}