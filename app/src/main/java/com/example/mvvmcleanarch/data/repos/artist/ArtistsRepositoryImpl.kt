package com.example.mvvmcleanarch.data.repos.artist

import android.util.Log
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
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val artistList = getArtistsFromAPI()
        artistsLocalDataSource.deleteAllArtists()
        artistsLocalDataSource.saveArtistsToDb(artistList)
        artistsCacheDataSource.saveArtistsToCache(artistList)
        return artistList
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            val response = artistsRemoteDataSource.getPopularArtists()
            val body = response.body()
            body?.let {
                artistList = body.results
            }
        }catch (e: Exception){
            Log.i(TAG, "getArtistsFromAPI: ${e.message}")
        }
        return artistList
    }

    suspend fun getArtistsFromDb(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistsLocalDataSource.getArtistFromDb()
        }catch (e: Exception){
            Log.i(TAG, "getArtistsFromDb: ${e.message}")
        }
        if(artistList.isEmpty()){
            artistList = getArtistsFromAPI()
            artistsLocalDataSource.saveArtistsToDb(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistsCacheDataSource.getArtistFromCache()
        }catch (e: Exception){
            Log.i(TAG, "getArtistsFromCache: ${e.message}")
        }
        if(artistList.isEmpty()){
            artistList = getArtistsFromDb()
            artistsCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

    companion object{
        const val TAG = "ArtistsRepositoryImpl"
    }
}