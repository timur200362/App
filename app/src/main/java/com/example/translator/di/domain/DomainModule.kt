package com.example.translator.di.domain

import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.api.TranslateUseCaseImpl
import com.example.translator.domain.usecase.database.AddToFavoriteUseCase
import com.example.translator.domain.usecase.database.AddToFavoriteUseCaseImpl
import com.example.translator.domain.usecase.database.GetFavoritesUseCase
import com.example.translator.domain.usecase.database.GetFavoritesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindTranslateUseCase(
        translateUseCaseImpl: TranslateUseCaseImpl,
    ): TranslateUseCase

    @Binds
    fun bindAddToFavoriteUseCase(
        addToFavoriteUseCaseImpl: AddToFavoriteUseCaseImpl,
    ): AddToFavoriteUseCase

    @Binds
    fun bindGetFavoritesUseCase(
        getFavoritesUseCaseImpl: GetFavoritesUseCaseImpl,
    ): GetFavoritesUseCase

    companion object {
        //provide
    }

}