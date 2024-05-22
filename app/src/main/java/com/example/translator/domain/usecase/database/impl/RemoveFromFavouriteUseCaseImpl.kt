package com.example.translator.domain.usecase.database.impl

import com.example.translator.data.database.WordEntity
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.database.interfaces.RemoveFromFavouriteUseCase
import javax.inject.Inject

class RemoveFromFavouriteUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository
): RemoveFromFavouriteUseCase {
    override suspend fun invoke(id: Int): List<WordEntity> = repository.removeFromFavourite(id)
}