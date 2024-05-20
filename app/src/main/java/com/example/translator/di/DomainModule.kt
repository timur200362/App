package com.example.translator.di

import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.usecase.TranslateUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideTranslateUseCase(
        translationRepository: TranslationRepository
    ): TranslateUseCase = TranslateUseCase(translationRepository)
}