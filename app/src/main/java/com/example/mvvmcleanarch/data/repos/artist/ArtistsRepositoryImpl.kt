package com.example.mvvmcleanarch.data.repos.artist

import com.example.mvvmcleanarch.data.model.artist.Artist
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsCacheDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsLocalDataSource
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsRemoteDataSource
import com.example.mvvmcleanarch.domain.repositories.ArtistsRepository

class ArtistsRepositoryImpl(
    private val artistsRemoteDataSource: ArtistsRemoteDataSource,
    private val artistsLocalDataSource: ArtistsLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource,
): ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }
}