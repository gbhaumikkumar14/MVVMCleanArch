package com.example.mvvmcleanarch.domain.useCases

import com.example.mvvmcleanarch.domain.repositories.ArtistsRepository
import com.example.mvvmcleanarch.data.model.artist.Artist

class GetArtistsUseCase(private val repo: ArtistsRepository) {
    suspend fun execute(): List<Artist>? = repo.getArtists()
}