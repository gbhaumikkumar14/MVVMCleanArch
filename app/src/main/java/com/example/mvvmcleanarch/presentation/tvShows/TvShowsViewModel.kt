package com.example.mvvmcleanarch.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarch.domain.useCases.GetTvShowsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        tvShows?.let {
            this.emit(tvShows)
        }
    }

    fun updateTvShows() = liveData {
        val newTvShows = updateTvShowsUseCase.execute()
        newTvShows?.let {
            this.emit(newTvShows)
        }
    }
}