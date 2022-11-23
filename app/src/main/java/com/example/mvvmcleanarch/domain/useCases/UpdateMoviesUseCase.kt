package com.example.mvvmcleanarch.domain.useCases

import com.example.mvvmcleanarch.domain.repositories.MoviesRepository
import com.example.mvvmcleanarch.data.model.movie.Movie

class UpdateMoviesUseCase(private val repo: MoviesRepository) {
    suspend fun execute(): List<Movie>? = repo.updateMovies()
}