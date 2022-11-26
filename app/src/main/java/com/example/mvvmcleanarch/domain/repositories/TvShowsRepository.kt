package com.example.mvvmcleanarch.domain.repositories

import com.example.mvvmcleanarch.data.model.tvShow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}