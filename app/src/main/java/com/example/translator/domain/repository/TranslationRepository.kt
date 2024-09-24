package com.example.translator.domain.repository

import com.example.translator.data.database.WordEntity

interface TranslationRepository {
    suspend fun translateWord(word: String): List<String>
    suspend fun addToFavourite(id: Int): List<WordEntity>
    suspend fun removeFromFavourite(id: Int): List<WordEntity>
    suspend fun removeFromCache(id: Int): List<WordEntity>
    suspend fun getCache(): List<WordEntity>
    suspend fun getFavourites(): List<WordEntity>
}