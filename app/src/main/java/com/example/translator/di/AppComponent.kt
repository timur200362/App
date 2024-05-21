package com.example.translator.di

import android.content.Context
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

//    @Provides
//    fun provideFactory(
//        translateUseCase: TranslateUseCase,
//        insertUseCase: InsertUseCase,
//        deleteUseCase: DeleteUseCase,
//        getAllUseCase: GetAllUseCase
//    ): ViewModelProvider.Factory = viewModelFactory {
//        initializer {
//            TranslateViewModel(
//                translateUseCase,
//                insertUseCase,
//                deleteUseCase,
//                getAllUseCase
//            )
//        }
//    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent//appcomponent
    }
}