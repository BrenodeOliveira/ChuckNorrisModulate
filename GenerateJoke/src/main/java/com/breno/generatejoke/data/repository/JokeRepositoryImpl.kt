package com.breno.generatejoke.data.repository

import com.breno.generatejoke.data.source.JokeDataSource
import com.breno.generatejoke.domain.model.JokeModel
import com.breno.generatejoke.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow

internal class JokeRepositoryImpl(private val jokeDataSource: JokeDataSource): JokeRepository {

    override fun getJoke(category: String): Flow<JokeModel> {
        return jokeDataSource.generateJoke(category)
    }
}