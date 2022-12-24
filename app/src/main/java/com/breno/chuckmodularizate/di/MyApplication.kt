package com.breno.chuckmodularizate.di

import android.app.Application
import com.breno.di.networkModule
import com.breno.generatejoke.di.dataJokeModule
import com.breno.generatejoke.di.domainJokeModule
import com.breno.generatejoke.di.presentationJokeModule
import com.breno.generatejoke.presentation.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            val listModules = listOf(
                dataCategoryModule, dataJokeModule, domainModule,
                domainJokeModule, presentationJokeModule, presentationModule,
                navigationModule, networkModule,
            )
            modules(listModules)
        }
    }
}