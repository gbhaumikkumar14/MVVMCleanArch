package com.example.mvvmcleanarch.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarch.data.model.tvShow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query(value = "DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query(value = "SELECT * FROM popular_tvShows")
    suspend fun getAllTvShows(): List<TvShow>
}