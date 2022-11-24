package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.data.api.TMDBService
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsRemoteDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl.ArtistsRemoteDataSourceImpl
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesRemoteDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl.MoviesRemoteDataSourceImpl
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMoviesRemoteDataSource(
        tmdbService: TMDBService): MoviesRemoteDataSource{
        return MoviesRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowsRemoteDataSource(
        tmdbService: TMDBService): TvShowsRemoteDataSource{
        return TvShowsRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistsRemoteDataSource(
        tmdbService: TMDBService): ArtistsRemoteDataSource{
        return ArtistsRemoteDataSourceImpl(tmdbService, apiKey)
    }
}