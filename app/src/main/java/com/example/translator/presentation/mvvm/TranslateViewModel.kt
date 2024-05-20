package com.example.translator.presentation.mvvm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.domain.usecase.TranslateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TranslateViewModel @Inject constructor(
    private val translateUseCase: TranslateUseCase
): ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    fun translateWord(word: String) {
        viewModelScope.launch {
            val translatedWord = translateUseCase.execute(word)
            _resultTranslate.value = translatedWord
        }
    }
}