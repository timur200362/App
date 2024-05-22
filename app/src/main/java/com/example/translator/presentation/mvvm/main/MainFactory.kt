package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.domain.usecase.api.interfaces.TranslateUseCase
import com.example.translator.domain.usecase.database.interfaces.AddToFavouriteUseCase
import com.example.translator.domain.usecase.database.interfaces.GetCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromFavouriteUseCase
import javax.inject.Inject


class MainFactory @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val addToFavouriteUseCase: AddToFavouriteUseCase,
    private val removeFromFavouriteUseCase: RemoveFromFavouriteUseCase,
    private val removeFromCacheUseCase: RemoveFromCacheUseCase,
    private val getCacheUseCase: GetCacheUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                translateUseCase,
                addToFavouriteUseCase,
                removeFromFavouriteUseCase,
                removeFromCacheUseCase,
                getCacheUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}