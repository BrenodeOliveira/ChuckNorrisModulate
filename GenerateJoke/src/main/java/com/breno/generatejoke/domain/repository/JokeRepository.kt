package com.breno.generatejoke.domain.repository

import com.breno.generatejoke.domain.model.JokeModel
import kotlinx.coroutines.flow.Flow

internal interface JokeRepository {

    fun getJoke(category: String): Flow<JokeModel>
}