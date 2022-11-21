package com.breno.generatejoke.data.service

import com.breno.generatejoke.data.model.JokeData
import retrofit2.http.GET
import retrofit2.http.Query

internal interface JokeService {

    @GET("random?category={category}")
    suspend fun getGeneratedJoke(@Query("category") category: String): JokeData
}