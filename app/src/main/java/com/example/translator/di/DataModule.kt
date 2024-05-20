package com.example.translator.di

import com.example.translator.data.remote.ApiService
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.repository.TranslationRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class DataModule {
    @Provides
    fun provideTranslationRepository(
        apiService: ApiService
    ): TranslationRepository = TranslationRepositoryImpl(apiService)
}