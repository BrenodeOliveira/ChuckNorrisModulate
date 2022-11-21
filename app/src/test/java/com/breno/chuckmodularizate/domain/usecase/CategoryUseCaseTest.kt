package com.breno.chuckmodularizate.domain.usecase

import com.breno.chuckmodularizate.domain.repository.CategoryListRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

internal class CategoryUseCaseTest {

    private val repository: CategoryListRepository = mockk(relaxed = true)
    private val useCase = CategoryUseCase(repository)

    @Test
    fun `UseCase Should return a list of strings`() {
        //Given
        val expectedList = listOf("1", "2")
        every { repository.fetchCategory() } returns flowOf(expectedList)
        //When
        val result = useCase()
        //Then
        runBlocking {
            assertEquals(expectedList, result.first())
        }
    }
}