package com.example.translator.domain.repository

import com.example.translator.data.remote.ApiFactory
import com.example.translator.data.remote.ApiService
import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.data.repository.TranslationRepository

data object TranslationRepositoryImpl: TranslationRepository {
    override suspend fun translateWord(word: String): TranslationResponse {
        return ApiFactory.translateApi.loadTranslation(word)
    }
}