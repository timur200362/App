package com.example.translator.data.repository

import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.domain.repository.TranslationRepositoryImpl

interface TranslationRepository {
    suspend fun translateWord(word: String): List<String>
}