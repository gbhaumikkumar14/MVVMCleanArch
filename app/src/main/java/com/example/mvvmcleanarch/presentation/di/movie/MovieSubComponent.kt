package com.example.mvvmcleanarch.presentation.di.movie

import com.example.mvvmcleanarch.presentation.movies.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    interface Factory{
        fun create(): MovieSubComponent
    }
}