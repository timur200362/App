package com.example.translator.di

import android.content.Context
import com.example.translator.presentation.screens.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [DomainModule::class, DataModule::class]
)

@Singleton
interface AppComponent {

    fun injectMainFragment(fragment: MainFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}