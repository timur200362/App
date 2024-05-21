package com.example.translator.di

import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
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
    fun provideDeleteUseCase(
        translationRepository: TranslationRepository
    ): DeleteUseCase = DeleteUseCase(translationRepository)
    @Provides
    fun provideGetAllUseCase(
        translationRepository: TranslationRepository
    ): GetAllUseCase = GetAllUseCase(translationRepository)
}