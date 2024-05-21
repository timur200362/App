package com.example.translator.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.domain.usecase.database.DeleteUseCase
import com.example.translator.domain.usecase.database.GetAllUseCase
import com.example.translator.domain.usecase.database.InsertUseCase
import com.example.translator.presentation.mvvm.TranslateViewModel
import com.example.translator.presentation.screens.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Component(
    modules = [DomainModule::class, DataModule::class]
)

@Singleton
interface AppComponent {

    fun injectMainFragment(fragment: MainFragment)

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