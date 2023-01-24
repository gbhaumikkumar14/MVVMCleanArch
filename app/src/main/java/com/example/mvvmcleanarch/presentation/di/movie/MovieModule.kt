package com.example.mvvmcleanarch.presentation.di.movie

import com.example.mvvmcleanarch.domain.useCases.GetMoviesUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateMoviesUseCase
import com.example.mvvmcleanarch.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {

    @ActivityScoped // custom scope
    @Provides
    fun provideMoviesViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MoviesViewModelFactory{
        return MoviesViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}