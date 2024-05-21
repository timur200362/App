package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordDB
import com.example.translator.data.repository.TranslationRepository

class InsertUseCase(
    private val translationRepository: TranslationRepository
) {
    suspend fun execute(wordDB: WordDB) {
        return translationRepository.insert(wordDB)
    }
}