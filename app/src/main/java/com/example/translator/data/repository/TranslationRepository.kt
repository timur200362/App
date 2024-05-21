package com.example.translator.data.repository

import com.example.translator.data.database.WordDB
import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.domain.repository.TranslationRepositoryImpl

interface TranslationRepository {
    suspend fun translateWord(word: String): List<String>
    suspend fun insert(wordDB: WordDB)
    suspend fun delete(id: Int)
    suspend fun getAll(): List<WordDB>
    suspend fun getFavourites(): List<WordDB>
}