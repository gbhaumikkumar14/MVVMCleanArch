package com.example.mvvmcleanarch.data.repos.tvShow.dataSourceImpl

import com.example.mvvmcleanarch.data.database.TvShowDao
import com.example.mvvmcleanarch.data.model.tvShow.TvShow
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(
    private val tvShowDao: TvShowDao
): TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDb(): List<TvShow> = tvShowDao.getAllTvShows()

    override suspend fun deleteAllTvShowInDb() {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.deleteAllTvShows()
       }
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }
}