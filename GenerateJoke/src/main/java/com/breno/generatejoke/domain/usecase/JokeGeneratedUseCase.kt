package com.breno.generatejoke.domain.usecase

import com.breno.generatejoke.domain.model.JokeModel
import com.breno.generatejoke.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow

internal class JokeGeneratedUseCase(private val repository: JokeRepository) {

    operator fun invoke(category: String): Flow<JokeModel> {
        return repository.getJoke(category)
    }
}