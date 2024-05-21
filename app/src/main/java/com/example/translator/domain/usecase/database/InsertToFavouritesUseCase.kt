package com.example.translator.domain.usecase.database

import com.example.translator.data.repository.TranslationRepository

class InsertToFavouritesUseCase(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(id: Int) {
        return translationRepository.insertToFavourites(id)
    }
}