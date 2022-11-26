package com.example.mvvmcleanarch.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarch.domain.useCases.GetMoviesUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        // since here we have not declared dispatcher coroutine will use main
        val movieList = getMoviesUseCase.execute()
        movieList?.let {
            this.emit(movieList)
        }
    }

    fun updateMovies() = liveData {
        // since here we have not declared dispatcher coroutine will use main
        val newMovieList = updateMoviesUseCase.execute()
        newMovieList?.let {
            this.emit(newMovieList)
        }
    }
}