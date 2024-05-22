package com.example.translator.domain.repository

import com.example.translator.data.database.WordDatabase
import com.example.translator.data.database.WordEntity
import com.example.translator.data.remote.ApiService
import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    wordDatabase: WordDatabase,
) : TranslationRepository {

    private val wordDao = wordDatabase.wordDao()

    override suspend fun translateWord(word: String): List<String> {
        val result = apiService.loadTranslation(word).map {
            it.meanings.first().translation.text
        }

        wordDao.insert(WordEntity(word = word, isFavorite = false))

        return result
    }

    override suspend fun addToFavourite(id: Int): List<WordEntity> {
        return wordDao.insertToFavoriteAndGetAll(id)
    }

    override suspend fun removeFromFavourite(id: Int): List<WordEntity> {
        return wordDao.deleteFromFavoriteAndGetAll(id)
    }

    override suspend fun removeFromCache(id: Int): List<WordEntity> {
        return wordDao.deleteAndGetAll(id)
    }

    override suspend fun getCache(): List<WordEntity> {
        return wordDao.getAll()
    }

    override suspend fun getFavourites(): List<WordEntity> {
        return wordDao.getFavourites()
    }

}