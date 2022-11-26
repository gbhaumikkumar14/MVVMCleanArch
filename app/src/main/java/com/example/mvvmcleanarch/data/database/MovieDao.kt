package com.example.mvvmcleanarch.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarch.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query(value = "DELETE FROM POPULAR_MOVIES")
    suspend fun deleteAllMovies()

    @Query(value = "SELECT * FROM POPULAR_MOVIES")
    suspend fun getAllMovies(): List<Movie>
}