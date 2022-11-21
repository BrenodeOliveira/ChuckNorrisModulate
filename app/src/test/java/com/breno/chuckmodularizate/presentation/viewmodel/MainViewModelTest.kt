package com.breno.chuckmodularizate.presentation.viewmodel

import com.breno.chuckmodularizate.domain.usecase.CategoryUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MainViewModelTest {

    private val categoryUseCase: CategoryUseCase = mockk(relaxed = true)
    private val viewModel = MainViewModel(categoryUseCase)

    @Test
    fun `ViewModel Should return a list of string When UseCase returns success`() {
        //Given
        val expectedList = listOf("1", "2")
        every { categoryUseCase() } returns flowOf(expectedList)
        //When
        viewModel.fetchCategories()
        //Then
        assertEquals(expectedList, viewModel.categories)
    }
}