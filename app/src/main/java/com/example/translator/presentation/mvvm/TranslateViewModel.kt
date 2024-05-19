package com.example.translator.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.domain.usecase.TranslateUseCase
import kotlinx.coroutines.launch

class TranslateViewModel: ViewModel() {
    private val _resultTranslate = MutableLiveData<TranslationResponse>()
    val resultTranslate: LiveData<TranslationResponse>
        get() = _resultTranslate

//    fun translateWord(word: String) {
//        viewModelScope.launch {
//            val translatedWord = TranslateUseCase().execute(word)
//        }
//    }
}