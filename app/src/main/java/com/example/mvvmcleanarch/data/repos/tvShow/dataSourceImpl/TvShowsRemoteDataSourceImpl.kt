package com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl

import com.example.mvvmcleanarch.data.api.TMDBService
import com.example.mvvmcleanarch.data.model.tvShow.TvShowList
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
): TvShowsRemoteDataSource {

    override suspend fun getPopularTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}