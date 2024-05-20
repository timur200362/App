package com.example.translator.domain.repository

import com.example.translator.data.remote.ApiFactory
import com.example.translator.data.remote.ApiService
import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TranslationRepository {
    override suspend fun translateWord(word: String): List<String> {
        return apiService.loadTranslation(word).map {
            it.meanings.first().translation.text
        }
    }
}