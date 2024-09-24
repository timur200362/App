package com.example.translator.di.data

import com.example.translator.domain.repository.TranslationRepository
import com.example.translator.data.repository.TranslationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
interface DataModule {

    @Binds
    fun bindTranslationRepository(
        translationRepositoryImpl: TranslationRepositoryImpl
    ): TranslationRepository

}