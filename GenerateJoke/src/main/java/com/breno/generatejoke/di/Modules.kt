package com.breno.generatejoke.di

import com.breno.generatejoke.data.repository.JokeRepositoryImpl
import com.breno.generatejoke.data.service.JokeService
import com.breno.generatejoke.data.source.JokeDataSource
import com.breno.generatejoke.domain.repository.JokeRepository
import com.breno.generatejoke.domain.usecase.JokeGeneratedUseCase
import com.breno.generatejoke.presentation.viewmodel.JokeViewModel
import com.breno.network.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataJokeModule = module {
    factory {
        get<HttpClient>().create(service = JokeService::class.java)
    }

    factory {
        JokeDataSource(service = get())
    }
}

val domainJokeModule = module {
    factory {
        JokeGeneratedUseCase(repository = get())
    }

    factory<JokeRepository> {
        JokeRepositoryImpl(jokeDataSource = get())
    }
}

val presentationJokeModule = module {
    viewModel {
        JokeViewModel(useCase = get())
    }
}