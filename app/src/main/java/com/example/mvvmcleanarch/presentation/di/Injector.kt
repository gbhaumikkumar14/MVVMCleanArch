package com.example.mvvmcleanarch.presentation.di

import com.example.mvvmcleanarch.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarch.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarch.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}