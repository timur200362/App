package com.example.translator.data.repository

import com.example.translator.data.database.WordEntity

interface TranslationRepository {
    suspend fun translateWord(word: String): List<String>
    suspend fun addToFavorite(id: Int): List<WordEntity>//todo wordDomain
    suspend fun removeFromFavorite(id: Int): List<WordEntity>//todo wordDomain
    suspend fun removeFromCache(id: Int): List<WordEntity> //todo wordDomain
    suspend fun getCache(): List<WordEntity>//todo wordDomain
    suspend fun getFavorites(): List<WordEntity>
}