package com.example.mvvmcleanarch.presentation.di.tvshow

import com.example.mvvmcleanarch.domain.useCases.GetTvShowsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateTvShowsUseCase
import com.example.mvvmcleanarch.presentation.tvShows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope // custom scope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowsViewModelFactory{
        return TvShowsViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}