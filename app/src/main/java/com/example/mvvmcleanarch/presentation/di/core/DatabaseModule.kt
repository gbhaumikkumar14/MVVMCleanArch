package com.example.mvvmcleanarch.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.mvvmcleanarch.data.database.ArtistDao
import com.example.mvvmcleanarch.data.database.MovieDao
import com.example.mvvmcleanarch.data.database.TMDBDatabase
import com.example.mvvmcleanarch.data.database.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            TMDBDatabase::class.java,
            "TMDB_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowDao
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao
    }
}