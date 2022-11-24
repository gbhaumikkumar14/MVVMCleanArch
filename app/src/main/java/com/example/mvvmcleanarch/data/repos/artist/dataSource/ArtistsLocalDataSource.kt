package com.example.mvvmcleanarch.data.repos.artist.dataSource

import com.example.mvvmcleanarch.data.model.artist.Artist

interface ArtistsLocalDataSource {
    suspend fun getArtistFromDb(): List<Artist>
    suspend fun deleteAllArtists()
    suspend fun saveArtistsToDb(artists: List<Artist>)
}