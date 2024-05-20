package com.example.translator.di

import com.example.translator.domain.usecase.TranslateUseCase
import com.example.translator.presentation.mvvm.TranslateViewModel
import com.example.translator.presentation.screens.MainFragment
import dagger.Component

@Component(modules = [ApplicationModule::class, DomainModule::class,DataModule::class])
interface ApplicationComponent {
    fun injectMainFragment(fragment: MainFragment)
    fun injectTranslateViewModel(viewModel: TranslateViewModel)
    fun injectTranslateRepository(useCase: TranslateUseCase)
}