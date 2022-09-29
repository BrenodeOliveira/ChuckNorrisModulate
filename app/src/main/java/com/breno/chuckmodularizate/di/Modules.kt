package com.breno.chuckmodularizate.di

import com.breno.chuckmodularizate.data.remote.retrofit.ApiService
import com.breno.chuckmodularizate.data.remote.retrofit.HttpClient
import com.breno.chuckmodularizate.data.repository.CategoryListRepositoryImpl
import com.breno.chuckmodularizate.data.service.CategoryService
import com.breno.chuckmodularizate.data.source.CategoryListDataSource
import com.breno.chuckmodularizate.domain.repository.CategoryListRepository
import com.breno.chuckmodularizate.domain.usecase.CategoryUseCase
import com.breno.chuckmodularizate.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }

    factory {
        get<HttpClient>().create(
            service = CategoryService::class.java
        )
    }

    factory {
        CategoryListDataSource(service = get())
    }

    factory<CategoryListRepository> {
        CategoryListRepositoryImpl(dataSource = get())
    }
}

val domainModule = module {
    factory {
        CategoryUseCase(repository = get())
    }
}

val presentationModule = module {
    viewModel {
        MainViewModel(categoryUseCase = get())
    }
}