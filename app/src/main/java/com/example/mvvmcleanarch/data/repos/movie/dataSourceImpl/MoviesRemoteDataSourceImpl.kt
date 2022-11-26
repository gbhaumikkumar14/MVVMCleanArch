package com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl

import com.example.mvvmcleanarch.data.api.TMDBService
import com.example.mvvmcleanarch.data.model.movie.MovieList
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesRemoteDataSource
import retrofit2.Response

class MoviesRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String) : MoviesRemoteDataSource {

    override suspend fun getPopularMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)
}