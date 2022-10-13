package com.breno.chuckmodularizate.di

import android.app.Application
import com.breno.di.networkModule
import com.breno.generatejoke.presentation.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            val listModules = listOf(dataModule, domainModule,
                presentationModule, navigationModule, networkModule)
            modules(listModules)
        }
    }
}