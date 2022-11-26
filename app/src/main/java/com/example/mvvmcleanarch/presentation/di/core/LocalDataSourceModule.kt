package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.data.database.ArtistDao
import com.example.mvvmcleanarch.data.database.MovieDao
import com.example.mvvmcleanarch.data.database.TvShowDao
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsLocalDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl.ArtistsLocalDataSourceImpl
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesLocalDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl.MoviesLocalDataSourceImpl
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsLocalDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideMoviesLocalDataSource(movieDao: MovieDao): MoviesLocalDataSource{
        return MoviesLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowDao: TvShowDao): TvShowsLocalDataSource{
        return TvShowsLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistDao: ArtistDao): ArtistsLocalDataSource{
        return ArtistsLocalDataSourceImpl(artistDao)
    }
}