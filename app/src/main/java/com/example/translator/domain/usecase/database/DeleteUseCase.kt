package com.example.translator.domain.usecase.database

import com.example.translator.data.repository.TranslationRepository

class DeleteUseCase(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(id: Int) {
        return translationRepository.delete(id)
    }
}