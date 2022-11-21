package com.breno.chuckmodularizate.data.source

import app.cash.turbine.test
import com.breno.chuckmodularizate.data.service.CategoryService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class CategoryListDataSourceTest {

    private val service: CategoryService = mockk(relaxed = true)
    private val dataSource = CategoryListDataSource(service)

    @Test
    fun `DataSource Should return a flow list string`() {
        //Given
        val expectedList = listOf("1", "2")
        coEvery { service.fetchCategories() } returns expectedList
        //When
        val result = dataSource.fetchCategories()
        //Then
        runBlocking {
            result.test {
                assertEquals(expectedList, expectMostRecentItem())
            }
        }
    }
}