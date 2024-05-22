package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.database.WordEntity
import com.example.translator.domain.usecase.api.interfaces.TranslateUseCase
import com.example.translator.domain.usecase.database.interfaces.AddToFavouriteUseCase
import com.example.translator.domain.usecase.database.interfaces.GetCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.GetFavouritesUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromFavouriteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val translateUseCase: TranslateUseCase,
    private val addToFavouriteUseCase: AddToFavouriteUseCase,
    private val removeFromFavouriteUseCase: RemoveFromFavouriteUseCase,
    private val removeFromCacheUseCase: RemoveFromCacheUseCase,
    private val getCacheUseCase: GetCacheUseCase

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
                _historyTranslate.update { getCacheUseCase.invoke() }
            } catch (exception: Exception) {
                _error.value = "Нет подключения к интернету!"
            }
        }
    }

    private fun loadAll() {
        viewModelScope.launch {
            runCatching {
                getCacheUseCase.invoke()
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
                removeFromFavouriteUseCase.invoke(wordEntity.wordId)
            } else {
                addToFavouriteUseCase(wordEntity.wordId)
            }
            _historyTranslate.update { result }
        }
    }

    fun deleteFromCache(wordEntity: WordEntity) {
        viewModelScope.launch {
            val result = removeFromCacheUseCase(wordEntity.wordId)
            _historyTranslate.update { result }
        }
    }
}