package com.example.mvvmcleanarch.presentation.di.core

import android.content.Context
import com.example.mvvmcleanarch.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarch.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarch.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    ArtistSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}