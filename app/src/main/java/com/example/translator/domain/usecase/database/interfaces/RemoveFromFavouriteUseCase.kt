package com.example.translator.domain.usecase.database.interfaces

import com.example.translator.data.database.WordEntity

interface RemoveFromFavouriteUseCase {
    suspend operator fun invoke(id: Int): List<WordEntity>
}