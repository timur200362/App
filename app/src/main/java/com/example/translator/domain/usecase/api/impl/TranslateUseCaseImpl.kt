package com.example.translator.domain.usecase.api.impl

import com.example.translator.domain.repository.TranslationRepository
import com.example.translator.domain.usecase.api.interfaces.TranslateUseCase
import javax.inject.Inject

class TranslateUseCaseImpl @Inject constructor(
    private val translationRepository: TranslationRepository,
) : TranslateUseCase {
    override suspend fun invoke(word: String): List<String> =
        translationRepository.translateWord(word)
}