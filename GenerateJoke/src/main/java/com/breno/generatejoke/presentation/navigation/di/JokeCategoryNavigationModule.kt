package com.breno.generatejoke.presentation.navigation.di

import com.breno.generatejoke.presentation.navigation.JokeActivityNavigationImpl
import com.breno.navigation.JokeActivityNavigation
import org.koin.dsl.module

val navigationModule = module {

    factory<JokeActivityNavigation> {
        JokeActivityNavigationImpl()
    }
}