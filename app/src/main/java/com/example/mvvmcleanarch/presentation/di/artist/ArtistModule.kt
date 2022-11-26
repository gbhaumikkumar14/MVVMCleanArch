package com.example.mvvmcleanarch.presentation.di.artist

import com.example.mvvmcleanarch.domain.useCases.GetArtistsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateArtistsUseCase
import com.example.mvvmcleanarch.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope // custom scope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}