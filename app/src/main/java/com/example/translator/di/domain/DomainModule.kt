package com.example.translator.di.domain

import com.example.translator.domain.usecase.api.impl.TranslateUseCaseImpl
import com.example.translator.domain.usecase.api.interfaces.TranslateUseCase
import com.example.translator.domain.usecase.database.interfaces.AddToFavouriteUseCase
import com.example.translator.domain.usecase.database.impl.AddToFavouriteUseCaseImpl
import com.example.translator.domain.usecase.database.impl.GetCacheUseCaseImpl
import com.example.translator.domain.usecase.database.interfaces.GetFavouritesUseCase
import com.example.translator.domain.usecase.database.impl.GetFavouritesUseCaseImpl
import com.example.translator.domain.usecase.database.impl.RemoveFromCacheUseCaseImpl
import com.example.translator.domain.usecase.database.impl.RemoveFromFavouriteUseCaseImpl
import com.example.translator.domain.usecase.database.interfaces.GetCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromCacheUseCase
import com.example.translator.domain.usecase.database.interfaces.RemoveFromFavouriteUseCase
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
        addToFavouriteUseCaseImpl: AddToFavouriteUseCaseImpl,
    ): AddToFavouriteUseCase

    @Binds
    fun bindRemoveFromFavouriteUseCase(
        removeFromFavouriteUseCaseImpl: RemoveFromFavouriteUseCaseImpl,
    ): RemoveFromFavouriteUseCase

    @Binds
    fun bindRemoveFromCacheUseCase(
        removeFromCacheUseCaseImpl: RemoveFromCacheUseCaseImpl,
    ): RemoveFromCacheUseCase

    @Binds
    fun bindGetCacheUseCase(
        getCacheUseCaseImpl: GetCacheUseCaseImpl,
    ): GetCacheUseCase

    @Binds
    fun bindGetFavoritesUseCase(
        getFavouritesUseCaseImpl: GetFavouritesUseCaseImpl,
    ): GetFavouritesUseCase
}