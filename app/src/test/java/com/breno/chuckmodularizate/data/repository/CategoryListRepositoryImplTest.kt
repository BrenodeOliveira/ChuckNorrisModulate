package com.breno.chuckmodularizate.data.repository

import app.cash.turbine.test
import com.breno.chuckmodularizate.data.source.CategoryListDataSource
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class CategoryListRepositoryImplTest {

    private val dataSource: CategoryListDataSource = mockk(relaxed = true)
    private val repository = CategoryListRepositoryImpl(dataSource)

    @Test
    fun `Repository Should return a list of strings`() {
        //Given
        val expectedList = listOf("1", "2")
        every { dataSource.fetchCategories() } returns flowOf(expectedList)
        //When
        val result = repository.fetchCategory()
        //Then
        runBlocking {
            result.test {
                assertEquals(expectedList, expectMostRecentItem())
            }
        }
    }
}