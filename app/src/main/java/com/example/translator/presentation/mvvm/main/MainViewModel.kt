package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.database.WordEntity
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.api.TranslateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val translateUseCase: TranslateUseCase,
    private val translationRepository: TranslationRepository,
) : ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    private val _historyTranslate = MutableStateFlow<List<WordEntity>>(emptyList())
    val historyTranslate: StateFlow<List<WordEntity>>
        get() = _historyTranslate

    private val _error = MutableStateFlow("")
    val error: StateFlow<String>
        get() = _error

    init {
        loadAll()
    }

    fun translateWord(word: String) {
        viewModelScope.launch {
            try {
                val translatedWord = translateUseCase(word)
                _resultTranslate.update { translatedWord }
                _historyTranslate.update { translationRepository.getCache() }
            } catch (exception: Exception) {
                _error.value = "Нет подключения к интернету!"
            }
        }
    }

    private fun loadAll() {
        viewModelScope.launch {
            runCatching {
                translationRepository.getCache()
            }.fold(
                onSuccess = { words ->
                    _historyTranslate.update { words }
                },
                onFailure = { _error.value = it.message.orEmpty() }
            )
        }
    }

    fun toggleToFavorite(wordEntity: WordEntity) {
        viewModelScope.launch {
            val result = if (wordEntity.isFavorite) {
                translationRepository.removeFromFavorite(wordEntity.wordId)
            } else {
                translationRepository.addToFavorite(wordEntity.wordId)
            }
            _historyTranslate.update { result }
        }
    }

    fun deleteFromCache(wordEntity: WordEntity) {
        viewModelScope.launch {
            val result = translationRepository.removeFromCache(wordEntity.wordId)
            _historyTranslate.update { result }
        }
    }
}