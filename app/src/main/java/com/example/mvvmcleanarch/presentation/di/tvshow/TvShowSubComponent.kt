package com.example.mvvmcleanarch.presentation.di.tvshow

import com.example.mvvmcleanarch.presentation.tvShows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowsActivity: TvShowsActivity)

    interface Factory{
        fun create():TvShowSubComponent
    }
}