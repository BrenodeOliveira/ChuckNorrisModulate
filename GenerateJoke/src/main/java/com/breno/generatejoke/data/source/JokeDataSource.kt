package com.breno.generatejoke.data.source

import com.breno.generatejoke.data.model.JokeData
import com.breno.generatejoke.data.service.JokeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class JokeDataSource(private val service: JokeService) {

    fun generateJoke(category: String): Flow<JokeData> {
        return flow {
            emit(service.getGeneratedJoke(category))
        }
    }
}