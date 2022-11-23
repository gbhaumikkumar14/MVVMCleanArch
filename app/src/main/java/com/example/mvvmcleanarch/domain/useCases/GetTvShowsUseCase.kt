package com.example.mvvmcleanarch.domain.useCases

import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository
import com.example.mvvmcleanarch.data.model.tvShow.TvShow

class GetTvShowsUseCase(private val repo: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = repo.getTvShows()
}