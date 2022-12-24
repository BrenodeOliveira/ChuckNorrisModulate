package com.breno.generatejoke.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breno.generatejoke.domain.usecase.JokeGeneratedUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class JokeViewModel(
    private val useCase: JokeGeneratedUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _categories: MutableLiveData<String> = MutableLiveData()
    val categories: LiveData<String> = _categories

    fun generateJoke(category: String) {
        viewModelScope.launch {
            useCase(category)
                .flowOn(dispatcher)
                .catch { _categories.value = it.message }
                .collect {
                    _categories.value = it.value
                }
        }
    }

}