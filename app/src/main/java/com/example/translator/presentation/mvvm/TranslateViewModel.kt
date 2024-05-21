package com.example.translator.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.translator.data.database.WordDB
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TranslateViewModel(
    private val translateUseCase: TranslateUseCase,
    private val insertUseCase: InsertUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val getAllUseCase: GetAllUseCase
) : ViewModel() {
    private val _resultTranslate = MutableStateFlow<List<String>>(emptyList())
    val resultTranslate: StateFlow<List<String>>
        get() = _resultTranslate

    private val _historyTranslate = MutableStateFlow<List<String>>(emptyList())
    val historyTranslate: StateFlow<List<String>>
        get() = _historyTranslate

    init {
        getAll()
    }

    fun translateWord(word: String) {
        viewModelScope.launch {
            val translatedWord = translateUseCase.execute(word)
            insert(WordDB(0,word))
            getAll()
            _resultTranslate.value = translatedWord
        }
    }

    private fun insert(wordDB: WordDB) {
        viewModelScope.launch {
            insertUseCase.execute(wordDB)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            deleteUseCase.execute(id)
        }
    }
    private fun getAll() {
        viewModelScope.launch {
            _historyTranslate.value = getAllUseCase.execute().map { it.word }
        }
    }
    companion object {
        fun provideFactory(
            translateUseCase: TranslateUseCase,
            insertUseCase: InsertUseCase,
            deleteUseCase: DeleteUseCase,
            getAllUseCase: GetAllUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TranslateViewModel(
                    translateUseCase,
                    insertUseCase,
                    deleteUseCase,
                    getAllUseCase
                )
            }
        }
    }
}