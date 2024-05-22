package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordEntity
import com.example.translator.data.repository.TranslationRepository
import javax.inject.Inject

class AddToFavoriteUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository,
) : AddToFavoriteUseCase {
    override suspend fun invoke(id: Int): List<WordEntity> = repository.addToFavorite(id)
}