package com.breno.chuckmodularizate.domain.usecase

import com.breno.chuckmodularizate.domain.repository.CategoryListRepository
import kotlinx.coroutines.flow.Flow

internal class CategoryUseCase(private val repository: CategoryListRepository) {

    operator fun invoke(): Flow<List<String>> {
        return repository.fetchCategory()
    }
}