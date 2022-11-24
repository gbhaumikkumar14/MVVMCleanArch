package com.example.mvvmcleanarch.data.repos.tvShow.dataSource

import com.example.mvvmcleanarch.data.model.tvShow.TvShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}