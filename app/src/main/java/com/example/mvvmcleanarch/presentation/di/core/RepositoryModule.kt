package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.data.repos.artist.ArtistsRepositoryImpl
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsCacheDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsLocalDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsRemoteDataSource
import com.example.mvvmcleanarch.data.repos.movie.MoviesRepositoryImpl
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesCacheDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesLocalDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesRemoteDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.TvShowsRepositoryImpl
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsCacheDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsLocalDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.mvvmcleanarch.domain.repositories.ArtistsRepository
import com.example.mvvmcleanarch.domain.repositories.MoviesRepository
import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(
        moviesRemoteDataSource: MoviesRemoteDataSource,
        moviesLocalDataSource: MoviesLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource): MoviesRepository{
        return MoviesRepositoryImpl(
            moviesRemoteDataSource,
            moviesLocalDataSource,
            moviesCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowsRepository{
        return TvShowsRepositoryImpl(
            tvShowsRemoteDataSource,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistsRemoteDataSource: ArtistsRemoteDataSource,
        artistsLocalDataSource: ArtistsLocalDataSource,
        artistsCacheDataSource: ArtistsCacheDataSource
    ): ArtistsRepository{
        return ArtistsRepositoryImpl(
            artistsRemoteDataSource,
            artistsLocalDataSource,
            artistsCacheDataSource)
    }
}