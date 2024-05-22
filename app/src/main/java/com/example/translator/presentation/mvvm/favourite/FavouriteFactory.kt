package com.example.translator.presentation.mvvm.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.domain.usecase.database.interfaces.GetFavouritesUseCase
import javax.inject.Inject

class FavouriteFactory @Inject constructor(
    private val getFavouritesUseCase: GetFavouritesUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouriteViewModel::class.java)) {
            return FavouriteViewModel(
                getFavouritesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}