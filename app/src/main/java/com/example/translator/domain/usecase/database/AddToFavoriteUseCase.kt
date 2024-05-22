package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordEntity

interface AddToFavoriteUseCase {
    suspend operator fun invoke(id: Int): List<WordEntity>
}