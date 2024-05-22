package com.example.translator.di.data

import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.repository.TranslationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
interface DataModule {

    @Binds
    fun bindTranslationRepository(
        translationRepositoryImpl: TranslationRepositoryImpl
    ): TranslationRepository

}