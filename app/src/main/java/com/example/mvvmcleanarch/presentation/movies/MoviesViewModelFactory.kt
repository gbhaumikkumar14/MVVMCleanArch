package com.example.mvvmcleanarch.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarch.domain.useCases.GetMoviesUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateMoviesUseCase

class MoviesViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}