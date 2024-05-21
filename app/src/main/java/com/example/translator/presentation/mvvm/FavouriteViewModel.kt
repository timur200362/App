package com.example.translator.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.data.database.WordDB
import com.example.translator.domain.usecase.database.GetFavouritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val getFavouritesUseCase: GetFavouritesUseCase
): ViewModel() {
    private val _favourites = MutableStateFlow<List<WordDB>>(emptyList())
    val favourites: StateFlow<List<WordDB>>
        get() = _favourites

    init {
        getFavouritesWords()
    }

    private fun getFavouritesWords() {
        viewModelScope.launch {
            _favourites.value = getFavouritesUseCase.execute()
        }
    }
    companion object {
        fun provideFactory(
            getFavouritesUseCase: GetFavouritesUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                FavouriteViewModel(
                    getFavouritesUseCase
                )
            }
        }
    }
}