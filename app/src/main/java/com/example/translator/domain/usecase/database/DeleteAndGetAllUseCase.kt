package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordDB
import com.example.translator.data.repository.TranslationRepository

class DeleteAndGetAllUseCase(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(id: Int): List<WordDB> {
        return translationRepository.deleteAndGetAll(id)
    }
}