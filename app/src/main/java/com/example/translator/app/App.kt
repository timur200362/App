package com.example.translator.app

import android.app.Application
import com.example.translator.di.ApplicationComponent
import com.example.translator.di.ApplicationModule
import com.example.translator.di.DaggerApplicationComponent

class App: Application() {
    val appComponent = DaggerApplicationComponent.builder().applicationModule(
        ApplicationModule(this)
    ).build()

    override fun onCreate() {
        super.onCreate()
    }
}