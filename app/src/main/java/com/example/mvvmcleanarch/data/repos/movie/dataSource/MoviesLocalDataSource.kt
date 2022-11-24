package com.example.mvvmcleanarch.data.repos.movie.dataSource

import com.example.mvvmcleanarch.data.model.movie.Movie

interface MoviesLocalDataSource {
    suspend fun getPopularMoviesFromDB(): List<Movie>
    suspend fun savePopularMoviesToDB(movies: List<Movie>)
    suspend fun deleteAllMoviesInDB()
}