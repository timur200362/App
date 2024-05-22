package com.example.translator.domain.usecase.api

import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class TranslateUseCaseImpl @Inject constructor(
    private val translationRepository: TranslationRepository,
) : TranslateUseCase {
    override suspend fun invoke(word: String): List<String> =
        translationRepository.translateWord(word)
}

interface TranslateUseCase {
    suspend operator fun invoke(word: String): List<String>
}