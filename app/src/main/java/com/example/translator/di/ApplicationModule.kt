package com.example.translator.di

import android.app.Application
import com.example.translator.data.remote.ApiService
import com.example.translator.data.repository.TranslationRepository
import com.example.translator.domain.repository.TranslationRepositoryImpl
import com.example.translator.domain.usecase.TranslateUseCase
import com.example.translator.presentation.mvvm.TranslateViewModel
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application) {
    @Provides
    fun provideTranslateViewModel(
        translateUseCase: TranslateUseCase
    ): TranslateViewModel = TranslateViewModel(translateUseCase)
}