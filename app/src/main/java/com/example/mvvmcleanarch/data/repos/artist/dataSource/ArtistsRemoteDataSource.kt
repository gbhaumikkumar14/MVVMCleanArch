package com.example.mvvmcleanarch.data.repos.artist.dataSource

import com.example.mvvmcleanarch.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistsRemoteDataSource {
    suspend fun getPopularArtists(): Response<ArtistList>
}