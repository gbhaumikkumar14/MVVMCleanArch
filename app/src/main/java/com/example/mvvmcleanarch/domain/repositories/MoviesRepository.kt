package com.example.mvvmcleanarch.domain.repositories

import com.example.mvvmcleanarch.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}