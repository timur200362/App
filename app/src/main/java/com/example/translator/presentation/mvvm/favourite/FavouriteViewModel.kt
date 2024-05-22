package com.example.translator.presentation.mvvm.favourite

import androidx.lifecycle.ViewModel
import com.example.translator.data.database.WordDB
import com.example.translator.domain.usecase.database.GetFavouritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
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

    fun getFavouritesWords() {
        viewModelScope.launch {
            _favourites.value = getFavouritesUseCase.execute()
        }
    }
}