package com.example.mvvmcleanarch.presentation.di.artist

import com.example.mvvmcleanarch.domain.useCases.GetArtistsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateArtistsUseCase
import com.example.mvvmcleanarch.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {

    @ActivityScoped // custom scope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}