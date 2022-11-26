package com.example.mvvmcleanarch.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarch.domain.useCases.GetArtistsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateArtistsUseCase

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        artists?.let {
            this.emit(artists)
        }
    }

    fun updateArtists() = liveData {
        val newArtists = updateArtistsUseCase.execute()
        newArtists?.let {
            this.emit(newArtists)
        }
    }
}