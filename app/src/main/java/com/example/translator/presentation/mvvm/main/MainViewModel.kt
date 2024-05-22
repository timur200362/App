package com.example.translator.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.database.WordDB
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteFromFavouritesUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertToFavouritesUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val translateUseCase: TranslateUseCase,
    private val insertUseCase: InsertUseCase,
    private val getAllUseCase: GetAllUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val insertToFavouritesUseCase: InsertToFavouritesUseCase,
    private val deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
) : ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    private val _historyTranslate = MutableStateFlow<List<WordDB>>(emptyList())
    val historyTranslate: StateFlow<List<WordDB>>
        get() = _historyTranslate

    private val _error = MutableStateFlow("")
    val error: StateFlow<String>
        get() = _error

    init {
        getAll()
    }

    fun translateWord(word: String) {
        viewModelScope.launch {
            try {
                val translatedWord = translateUseCase.execute(word)
                _resultTranslate.value = translatedWord
                insert(WordDB(0, word))
                getAll()
            }
            catch (exception: Exception) {
                _error.value = "Нет подключения к интернету!"
            }
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
                getAll()
            }
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            deleteUseCase.execute(id)
            getAll()
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

}