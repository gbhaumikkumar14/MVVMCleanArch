package com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl

import com.example.mvvmcleanarch.data.api.TMDBService
import com.example.mvvmcleanarch.data.model.artist.ArtistList
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsRemoteDataSource
import retrofit2.Response

class ArtistsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistsRemoteDataSource {
    override suspend fun getPopularArtists(): Response<ArtistList> =
        tmdbService.getPopularArtists(apiKey)
}