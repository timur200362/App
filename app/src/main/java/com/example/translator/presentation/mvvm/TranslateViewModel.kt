package com.example.translator.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.translator.data.database.WordDB
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteAndGetAllUseCase
import com.example.translator.domain.usecase.database.DeleteFromFavouritesUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertToFavouritesUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TranslateViewModel(
    private val translateUseCase: TranslateUseCase,
    private val insertUseCase: InsertUseCase,
    private val getAllUseCase: GetAllUseCase,
    private val deleteAndGetAllUseCase: DeleteAndGetAllUseCase,
    private val insertToFavouritesUseCase: InsertToFavouritesUseCase,
    private val deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
) : ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    private val _historyTranslate = MutableStateFlow<List<WordDB>>(emptyList())
    val historyTranslate: StateFlow<List<WordDB>>
        get() = _historyTranslate

    init {
        getAll()
    }

    fun translateWord(word: String) {
        viewModelScope.launch {
            val translatedWord = translateUseCase.execute(word)
            val insertJob = launch {
                insert(WordDB(0, word))
            }
            insertJob.join()

            val getAllJob = launch {
                getAll()
            }
            getAllJob.join()
            _resultTranslate.value = translatedWord
        }
    }

    fun toggleFavorite(id: Int) {
        viewModelScope.launch {
            val word = historyTranslate.value.find { it.wordId == id }

            if (word != null) {
                if (word.isFavorite == true) {
                    deleteFromFavourites(id)
                } else {
                    insertToFavourites(id)
                }
            }
        }
    }

    fun deleteAndGetAll(id: Int) {
        viewModelScope.launch {
            deleteAndGetAllUseCase.execute(id)
        }
    }

    private fun insert(wordDB: WordDB) {
        viewModelScope.launch {
            insertUseCase.execute(wordDB)
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            _historyTranslate.value = getAllUseCase.execute()
        }
    }

    private fun insertToFavourites(wordId: Int) {
        viewModelScope.launch {
            insertToFavouritesUseCase.execute(wordId)
        }
    }

    private fun deleteFromFavourites(wordId: Int) {
        viewModelScope.launch {
            deleteFromFavouritesUseCase.execute(wordId)
        }
    }

    companion object {
        fun provideFactory(
            translateUseCase: TranslateUseCase,
            insertUseCase: InsertUseCase,
            getAllUseCase: GetAllUseCase,
            deleteAndGetAllUseCase: DeleteAndGetAllUseCase,
            insertToFavouritesUseCase: InsertToFavouritesUseCase,
            deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TranslateViewModel(
                    translateUseCase,
                    insertUseCase,
                    getAllUseCase,
                    deleteAndGetAllUseCase,
                    insertToFavouritesUseCase,
                    deleteFromFavouritesUseCase,
                )
            }
        }
    }
}