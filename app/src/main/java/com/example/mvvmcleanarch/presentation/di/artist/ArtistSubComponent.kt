package com.example.mvvmcleanarch.presentation.di.artist

import com.example.mvvmcleanarch.presentation.artists.ArtistsActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistsActivity: ArtistsActivity)

    interface Factory{
        fun create():ArtistSubComponent
    }
}