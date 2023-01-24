package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsCacheDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl.ArtistsCacheDataSourceImpl
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesCacheDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl.MoviesCacheDataSourceImpl
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsCacheDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun provideMoviesCacheDataSource(): MoviesCacheDataSource{
        return MoviesCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowsCacheDataSource(): TvShowsCacheDataSource{
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistsCacheDataSource(): ArtistsCacheDataSource{
        return ArtistsCacheDataSourceImpl()
    }
}