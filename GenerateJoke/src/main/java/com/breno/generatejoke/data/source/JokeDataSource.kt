package com.breno.generatejoke.data.source

import com.breno.generatejoke.data.model.toModel
import com.breno.generatejoke.data.service.JokeService
import com.breno.generatejoke.domain.model.JokeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class JokeDataSource(private val service: JokeService) {

    fun generateJoke(category: String): Flow<JokeModel> {
        return flow {
            emit(service.getGeneratedJoke(category))
        }.map { it.toModel() }
    }
}