package com.breno.chuckmodularizate.data.source

import com.breno.chuckmodularizate.data.service.CategoryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CategoryListDataSource(private val service: CategoryService) {

    fun fetchCategories(): Flow<List<String>> {
        return flow {
            emit(service.fetchCategories())
        }
    }
}