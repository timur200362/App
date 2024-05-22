package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.api.TranslateUseCase
import javax.inject.Inject


class MainFactory @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val translationRepository: TranslationRepository,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                translateUseCase,
                translationRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}