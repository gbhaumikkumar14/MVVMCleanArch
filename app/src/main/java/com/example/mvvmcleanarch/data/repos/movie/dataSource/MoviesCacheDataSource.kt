package com.example.mvvmcleanarch.data.repos.movie.dataSource

import com.example.mvvmcleanarch.data.model.movie.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}