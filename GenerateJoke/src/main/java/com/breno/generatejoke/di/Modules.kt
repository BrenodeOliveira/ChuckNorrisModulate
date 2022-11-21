package com.breno.generatejoke.di

import com.breno.generatejoke.data.service.JokeService
import com.breno.generatejoke.data.source.JokeDataSource
import com.breno.network.HttpClient
import org.koin.dsl.module

val dataJokeModule = module {
    factory {
        get<HttpClient>().create(service = JokeService::class.java)
    }

    factory {
        JokeDataSource(service = get())
    }
}