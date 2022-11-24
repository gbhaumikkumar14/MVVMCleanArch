package com.example.mvvmcleanarch.data.repos.artist.dataSourceImpl

import com.example.mvvmcleanarch.data.database.ArtistDao
import com.example.mvvmcleanarch.data.model.artist.Artist
import com.example.mvvmcleanarch.data.repos.artist.dataSource.ArtistsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImpl(
    private val artistDao: ArtistDao
): ArtistsLocalDataSource {
    override suspend fun getArtistFromDb(): List<Artist> = artistDao.getAllArtists()

    override suspend fun deleteAllArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }

    override suspend fun saveArtistsToDd(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }
}