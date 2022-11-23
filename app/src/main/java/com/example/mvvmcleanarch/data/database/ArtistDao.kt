package com.example.mvvmcleanarch.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarch.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query(value = "DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query(value = "SELECT * from popular_artists")
    suspend fun getAllArtists(): List<Artist>
}