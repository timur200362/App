package com.example.translator.domain.usecase

import com.example.translator.data.remote.response.TranslationResponse
import com.example.translator.data.repository.TranslationRepository

class TranslateUseCase {
    suspend fun execute(word: String): List<String> {
        return TranslationRepository.getInstance().translateWord(word)
    }
}