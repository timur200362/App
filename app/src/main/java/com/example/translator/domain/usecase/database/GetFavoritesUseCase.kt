package com.example.translator.domain.usecase.database

import com.example.translator.data.database.WordEntity

interface GetFavoritesUseCase {
    suspend operator fun invoke(): List<WordEntity>
}
