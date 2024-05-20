package com.example.translator.app

import android.app.Application
import com.example.translator.di.AppComponent
import com.example.translator.di.DaggerAppComponent

class App : Application(), AppComponentProvider {

    override lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}