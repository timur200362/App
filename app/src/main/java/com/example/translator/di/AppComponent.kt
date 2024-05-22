package com.example.translator.di

import android.content.Context
import com.example.translator.di.data.DataModule
import com.example.translator.di.domain.DomainModule
import com.example.translator.presentation.screens.FavouriteFragment
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
    fun injectFavouriteComponent(fragment: FavouriteFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}