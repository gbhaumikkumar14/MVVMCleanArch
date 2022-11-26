package com.example.mvvmcleanarch.data.repos.artist.dataSource

import com.example.mvvmcleanarch.data.model.artist.Artist

interface ArtistsCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}