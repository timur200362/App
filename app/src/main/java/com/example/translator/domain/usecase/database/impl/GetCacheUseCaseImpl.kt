package com.example.translator.domain.usecase.database.impl

import com.example.translator.data.database.WordEntity
import com.example.translator.domain.repository.TranslationRepository
import com.example.translator.domain.usecase.database.interfaces.GetCacheUseCase
import javax.inject.Inject

class GetCacheUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository
): GetCacheUseCase {
    override suspend fun invoke(): List<WordEntity> = repository.getCache()
}