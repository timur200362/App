package com.example.translator.domain.usecase.database.interfaces

import com.example.translator.data.database.WordEntity

interface GetFavouritesUseCase {
    suspend operator fun invoke(): List<WordEntity>
}
