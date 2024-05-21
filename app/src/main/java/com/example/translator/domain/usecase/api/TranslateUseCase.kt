package com.example.translator.domain.usecase.api

import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class TranslateUseCase @Inject constructor(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(word: String): List<String> {
        return translationRepository.translateWord(word)
    }
}