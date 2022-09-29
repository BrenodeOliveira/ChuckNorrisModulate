package com.breno.chuckmodularizate.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breno.chuckmodularizate.domain.usecase.CategoryUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val categoryUseCase: CategoryUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState
    private val _categories: MutableLiveData<List<String>> = MutableLiveData()
    val categories: LiveData<List<String>> = _categories

    fun fetchCategories() {
        viewModelScope.launch {
            categoryUseCase()
                .flowOn(dispatcher)
                .onStart { _loadingState.value = true }
                .catch { _categories.value = listOf() }
                .onCompletion { _loadingState.value = false }
                .collect {
                    _categories.value = it
                }
        }
    }
}