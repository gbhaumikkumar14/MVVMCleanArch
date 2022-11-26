package com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl

import com.example.mvvmcleanarch.data.model.artist.Artist
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsCacheDataSource

class ArtistsCacheDataSourceImpl: ArtistsCacheDataSource {
    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}