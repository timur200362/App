package com.example.translator.presentation.mvvm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translator.domain.usecase.TranslateUseCase

//class TranslateViewModelFactory(
//    private val application: Application,
//    private val translateUseCase: TranslateUseCase
//): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val searchWeatherViewModel = TranslateViewModel(application, translateUseCase)
//        return searchWeatherViewModel as T
//    }
//}