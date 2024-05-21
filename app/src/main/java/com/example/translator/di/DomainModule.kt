package com.example.translator.di

import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteAndGetAllUseCase
import com.example.translator.domain.usecase.database.DeleteFromFavouritesUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertToFavouritesUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideTranslateUseCase(
        translationRepository: TranslationRepository
    ): TranslateUseCase = TranslateUseCase(translationRepository)
    @Provides
    fun provideInsertUseCase(
        translationRepository: TranslationRepository
    ): InsertUseCase = InsertUseCase(translationRepository)
    @Provides
    fun provideGetAllUseCase(
        translationRepository: TranslationRepository
    ): GetAllUseCase = GetAllUseCase(translationRepository)
    @Provides
    fun provideDeleteAndGetAllUseCase(
        translationRepository: TranslationRepository
    ): DeleteAndGetAllUseCase = DeleteAndGetAllUseCase(translationRepository)
    @Provides
    fun provideInsertToFavouritesUseCase(
        translationRepository: TranslationRepository
    ): InsertToFavouritesUseCase = InsertToFavouritesUseCase(translationRepository)
    @Provides
    fun provideDeleteFromFavouritesUseCase(
        translationRepository: TranslationRepository
    ): DeleteFromFavouritesUseCase = DeleteFromFavouritesUseCase(translationRepository)
}