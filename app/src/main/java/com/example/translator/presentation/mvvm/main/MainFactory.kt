package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteFromFavouritesUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertToFavouritesUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import javax.inject.Inject


class MainFactory @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val insertUseCase: InsertUseCase,
    private val getAllUseCase: GetAllUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val insertToFavouritesUseCase: InsertToFavouritesUseCase,
    private val deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                translateUseCase,
                insertUseCase,
                getAllUseCase,
                deleteUseCase,
                insertToFavouritesUseCase,
                deleteFromFavouritesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}