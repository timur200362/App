package com.example.translator.presentation.mvvm.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.database.WordEntity
import com.example.translator.domain.usecase.database.GetFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val getFavouritesUseCase: GetFavoritesUseCase,
) : ViewModel() {
    private val _favourites = MutableStateFlow<List<WordEntity>>(emptyList())
    val favourites: StateFlow<List<WordEntity>>
        get() = _favourites

    init {
        getFavouritesWords()
    }

    fun getFavouritesWords() {
        viewModelScope.launch {
            _favourites.value = getFavouritesUseCase()
        }
    }
}