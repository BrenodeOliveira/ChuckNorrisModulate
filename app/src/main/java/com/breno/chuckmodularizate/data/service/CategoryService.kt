package com.breno.chuckmodularizate.data.service

import retrofit2.http.GET

internal interface CategoryService {

    @GET("categories")
    suspend fun fetchCategories(): List<String>
}