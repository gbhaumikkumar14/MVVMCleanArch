package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.domain.repositories.ArtistsRepository
import com.example.mvvmcleanarch.domain.repositories.MoviesRepository
import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository
import com.example.mvvmcleanarch.domain.useCases.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository): GetMoviesUseCase{
        return GetMoviesUseCase(moviesRepository)
    }
    @Provides
    fun provideUpdateMoviesUseCase(moviesRepository: MoviesRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistsRepository): GetArtistsUseCase{
        return GetArtistsUseCase(artistsRepository)
    }
    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistsRepository)
    }
}