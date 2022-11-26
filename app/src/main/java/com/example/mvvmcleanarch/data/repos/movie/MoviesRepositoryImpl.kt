package com.example.mvvmcleanarch.data.repos.movie

import android.util.Log
import com.example.mvvmcleanarch.data.model.movie.Movie
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesCacheDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesLocalDataSource
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesRemoteDataSource
import com.example.mvvmcleanarch.domain.repositories.MoviesRepository

open class MoviesRepositoryImpl(
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource
)
    : MoviesRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovies = getMoviesFromAPI()
        moviesLocalDataSource.deleteAllMoviesInDB()
        moviesLocalDataSource.savePopularMoviesToDB(newMovies)
        moviesCacheDataSource.saveMoviesToCache(newMovies)
        return newMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            val response = moviesRemoteDataSource.getPopularMovies()
            val body = response.body()
            body?.let {
                movieList = body.results
            }
        }catch (e : Exception){
            Log.i(TAG, "getMoviesFromAPI: ${e.message}")
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = moviesLocalDataSource.getPopularMoviesFromDB()
        }catch (e : Exception){
            Log.i(TAG, "getMoviesFromAPI: ${e.message}")
        }
        if(movieList.isEmpty()){
            movieList = getMoviesFromAPI()
            moviesLocalDataSource.savePopularMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = moviesCacheDataSource.getMoviesFromCache()
        }catch (e : Exception){
            Log.i(TAG, "getMoviesFromAPI: ${e.message}")
        }
        if(movieList.isEmpty()){
            movieList = getMoviesFromDB()
            moviesCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    companion object{
        const val TAG = "MoviesRepositoryImpl"
    }
}