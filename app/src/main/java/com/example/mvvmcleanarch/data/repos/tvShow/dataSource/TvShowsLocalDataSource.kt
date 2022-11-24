package com.example.mvvmcleanarch.data.repos.tvShow.dataSource

import com.example.mvvmcleanarch.data.model.tvShow.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun deleteAllTvShowInDb()
    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)
}