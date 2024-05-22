package com.example.translator.domain.usecase.database.interfaces

import com.example.translator.data.database.WordEntity

interface RemoveFromCacheUseCase {
    suspend operator fun invoke(id: Int): List<WordEntity>
}