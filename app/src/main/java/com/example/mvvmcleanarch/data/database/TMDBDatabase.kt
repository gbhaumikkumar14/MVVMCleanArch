package com.example.mvvmcleanarch.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmcleanarch.data.model.artist.Artist
import com.example.mvvmcleanarch.data.model.movie.Movie
import com.example.mvvmcleanarch.data.model.tvShow.TvShow

@Database(entities = [
    Movie::class,
    TvShow::class,
    Artist::class], version = 1)

abstract class TMDBDatabase : RoomDatabase(){
    abstract val movieDao: MovieDao
    abstract val tvShowDao: TvShowDao
    abstract val artistDao: ArtistDao

    companion object{
        @Volatile
        private var INSTANCE: TMDBDatabase? = null

        fun getInstance(context: Context): TMDBDatabase{
            var instance = INSTANCE
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TMDBDatabase::class.java,
                    "TMDB_database")
                    .build()
            }
            return instance
        }
    }
}