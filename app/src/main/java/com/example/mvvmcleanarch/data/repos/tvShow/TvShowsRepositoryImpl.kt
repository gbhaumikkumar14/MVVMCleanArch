package com.example.mvvmcleanarch.data.repos.tvShow

import android.util.Log
import com.example.mvvmcleanarch.data.model.tvShow.TvShow
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsCacheDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsLocalDataSource
import com.example.mvvmcleanarch.data.repos.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository

class TvShowsRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource
): TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShows = getTvShowsFromAPI()
        tvShowsLocalDataSource.deleteAllTvShowInDb()
        tvShowsLocalDataSource.saveTvShowsToDb(newTvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newTvShows)
        return newTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try{
            val response = tvShowsRemoteDataSource.getPopularTvShows()
            val body = response.body()
            body?.let {
                tvShowsList = body.results
            }
        }catch (e: Exception){
            Log.i(TAG, "getTvShowsFromAPI: ${e.message}")
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromDb(): List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try{
            tvShowsList = tvShowsLocalDataSource.getTvShowsFromDb()
        }catch (e: Exception){
            Log.i(TAG, "getTvShowsFromDb: ${e.message}")
        }
        if(tvShowsList.isEmpty()){
            tvShowsList = getTvShowsFromAPI()
            tvShowsLocalDataSource.saveTvShowsToDb(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try{
            tvShowsList = tvShowsCacheDataSource.getTvShowsFromCache()
        }catch (e: Exception){
            Log.i(TAG, "getTvShowsFromCache: ${e.message}")
        }
        if(tvShowsList.isEmpty()){
            tvShowsList = getTvShowsFromDb()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }

    companion object{
        const val TAG = "TvShowsRepository"
    }
}