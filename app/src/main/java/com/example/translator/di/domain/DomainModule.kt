package com.example.translator.di.domain

import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteFromFavouritesUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.GetFavouritesUseCase
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
    fun provideDeleteUseCase(
        translationRepository: TranslationRepository
    ): DeleteUseCase = DeleteUseCase(translationRepository)
    @Provides
    fun provideInsertToFavouritesUseCase(
        translationRepository: TranslationRepository
    ): InsertToFavouritesUseCase = InsertToFavouritesUseCase(translationRepository)
    @Provides
    fun provideDeleteFromFavouritesUseCase(
        translationRepository: TranslationRepository
    ): DeleteFromFavouritesUseCase = DeleteFromFavouritesUseCase(translationRepository)
    @Provides
    fun provideGetFavouritesUseCase(
        translationRepository: TranslationRepository
    ): GetFavouritesUseCase = GetFavouritesUseCase(translationRepository)
}