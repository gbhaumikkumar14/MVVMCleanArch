package com.example.mvvmcleanarch.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarch.domain.useCases.GetArtistsUseCase
import com.example.mvvmcleanarch.domain.useCases.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}