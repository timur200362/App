package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordDB
import com.example.translator.data.repository.TranslationRepository

class GetFavouritesUseCase(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(): List<WordDB> {
        return translationRepository.getAll()
    }
}