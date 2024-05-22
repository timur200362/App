package com.example.translator.domain.usecase.database.impl

import com.example.translator.data.database.WordEntity
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.database.interfaces.GetFavouritesUseCase
import javax.inject.Inject

class GetFavouritesUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository
) : GetFavouritesUseCase {
    override suspend fun invoke(): List<WordEntity> = repository.getFavourites()
}