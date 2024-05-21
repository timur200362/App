package com.example.translator.domain.repository

import com.example.translator.data.database.WordDB
import com.example.translator.data.database.WordDatabase
import com.example.translator.data.remote.ApiFactory
import com.example.translator.data.remote.ApiService
import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val wordDatabase: WordDatabase
) : TranslationRepository {
    override suspend fun translateWord(word: String): List<String> {
        return apiService.loadTranslation(word).map {
            it.meanings.first().translation.text
        }
    }

    override suspend fun insert(wordDB: WordDB) {
        wordDatabase.wordDao().insert(wordDB)
    }

    override suspend fun delete(id: Int) {
        wordDatabase.wordDao().delete(id)
    }

    override suspend fun getFavourites(): List<WordDB> {
        return wordDatabase.wordDao().getFavourites()
    }

    override suspend fun getAll(): List<WordDB> {
        return wordDatabase.wordDao().getAll()
    }
}