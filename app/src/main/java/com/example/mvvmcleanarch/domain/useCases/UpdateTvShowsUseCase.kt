package com.example.mvvmcleanarch.domain.useCases

import com.example.mvvmcleanarch.domain.repositories.TvShowsRepository
import com.example.mvvmcleanarch.data.model.tvShow.TvShow

class UpdateTvShowsUseCase(private val repo: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = repo.updateTvShows()
}