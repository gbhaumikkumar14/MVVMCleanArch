package com.example.mvvmcleanarch.presentation.di.movie

import com.example.mvvmcleanarch.domain.useCases.GetMoviesUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateMoviesUseCase
import com.example.mvvmcleanarch.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope // custom scope
    @Provides
    fun provideMoviesViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MoviesViewModelFactory{
        return MoviesViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}