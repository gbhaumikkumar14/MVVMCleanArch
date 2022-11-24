package com.example.mvvmcleanarch.data.repos.tvShow

import com.example.mvvmcleanarch.data.model.tvShow.TvShow
import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository

class TvShowsRepositoryImpl: TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}