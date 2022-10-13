package com.breno.di

import com.breno.network.ApiService
import com.breno.network.HttpClient
import org.koin.dsl.module

val networkModule = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }
}