package com.example.mvvmcleanarch.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarch.domain.useCases.GetTvShowsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}