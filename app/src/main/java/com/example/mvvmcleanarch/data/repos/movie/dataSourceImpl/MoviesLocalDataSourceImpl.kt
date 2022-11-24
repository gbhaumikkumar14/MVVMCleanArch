package com.example.mvvmcleanarch.data.repos.movie.dataSourceImpl

import com.example.mvvmcleanarch.data.model.movie.Movie
import com.example.mvvmcleanarch.data.repos.movie.dataSource.MoviesCacheDataSource

class MoviesLocalDataSourceImpl : MoviesCacheDataSource {
    private var cachedMovieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return cachedMovieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        cachedMovieList.clear()
        cachedMovieList = ArrayList(movies)
    }
}