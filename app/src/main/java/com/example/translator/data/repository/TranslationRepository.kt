package com.example.translator.data.repository

import com.example.translator.data.database.WordDB

interface TranslationRepository {
    suspend fun translateWord(word: String): List<String>
    suspend fun insert(wordDB: WordDB)
    suspend fun delete(id: Int)
    suspend fun getAll(): List<WordDB>
    suspend fun getFavourites(): List<WordDB>
    suspend fun insertToFavourites(id: Int)
    suspend fun deleteFromFavourites(id: Int)
}