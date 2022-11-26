package com.example.mvvmcleanarch.data.repos.tvShow.dataSource

import com.example.mvvmcleanarch.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getPopularTvShows(): Response<TvShowList>
}