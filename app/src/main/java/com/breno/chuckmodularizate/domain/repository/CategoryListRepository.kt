package com.breno.chuckmodularizate.domain.repository

import kotlinx.coroutines.flow.Flow

internal interface CategoryListRepository {

    fun fetchCategory(): Flow<List<String>>
}