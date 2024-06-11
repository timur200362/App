package com.example.translator.domain.usecase.database.impl

import com.example.translator.data.database.WordEntity
import com.example.translator.domain.repository.TranslationRepository
import com.example.translator.domain.usecase.database.interfaces.RemoveFromCacheUseCase
import javax.inject.Inject

class RemoveFromCacheUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository
): RemoveFromCacheUseCase {
    override suspend fun invoke(id: Int): List<WordEntity> = repository.removeFromCache(id)
}