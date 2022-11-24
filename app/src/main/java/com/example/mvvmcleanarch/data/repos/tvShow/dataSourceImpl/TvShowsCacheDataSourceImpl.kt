package com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl

import com.example.mvvmcleanarch.data.model.tvShow.TvShow
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl: TvShowsCacheDataSource {

    private var tvShowsList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowsList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}