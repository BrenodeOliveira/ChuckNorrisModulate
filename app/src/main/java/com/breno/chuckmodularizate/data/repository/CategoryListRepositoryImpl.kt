package com.breno.chuckmodularizate.data.repository

import com.breno.chuckmodularizate.data.source.CategoryListDataSource
import com.breno.chuckmodularizate.domain.repository.CategoryListRepository
import kotlinx.coroutines.flow.Flow

internal class CategoryListRepositoryImpl(private val dataSource: CategoryListDataSource) :
    CategoryListRepository {

    override fun fetchCategory(): Flow<List<String>> {
        return dataSource.fetchCategories()
    }
}