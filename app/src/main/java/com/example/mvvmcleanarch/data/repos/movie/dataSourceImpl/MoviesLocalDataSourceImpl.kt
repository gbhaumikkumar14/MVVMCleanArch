package com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl

import com.example.mvvmcleanarch.data.database.MovieDao
import com.example.mvvmcleanarch.data.model.movie.Movie
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesLocalDataSourceImpl(private val movieDao: MovieDao) : MoviesLocalDataSource {
    override suspend fun getPopularMoviesFromDB(): List<Movie> = movieDao.getAllMovies()

    override suspend fun savePopularMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun deleteAllMoviesInDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

}