package com.example.mvvmcleanarch.domain.repositories

import com.example.mvvmcleanarch.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}