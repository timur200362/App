package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordEntity
import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class GetFavoritesUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository,
) : GetFavoritesUseCase {
    override suspend fun invoke(): List<WordEntity> = repository.getFavorites()
}