package com.example.translator.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.translator.domain.usecase.TranslateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TranslateViewModel(
    private val translateUseCase: TranslateUseCase,
) : ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    fun translateWord(word: String) {
        viewModelScope.launch {
            val translatedWord = translateUseCase.execute(word)
            _resultTranslate.value = translatedWord
        }
    }

    companion object {
        fun provideFactory(
            translateUseCase: TranslateUseCase,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TranslateViewModel(
                    translateUseCase
                )
            }
        }
    }
}