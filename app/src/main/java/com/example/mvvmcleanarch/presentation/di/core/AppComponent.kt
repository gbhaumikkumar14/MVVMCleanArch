package com.example.mvvmcleanarch.presentation.di.core

import com.example.mvvmcleanarch.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarch.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarch.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataSourceModule::class,
    DatabaseModule::class,
    LocalDataSourceModule::class,
    NetworkModule::class,
    RemoteDataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

}