package com.example.mvvmquotesactivity.domain

import com.example.mvvmquotesactivity.data.model.QuoteModel
import com.example.mvvmquotesactivity.data.model.QuoteProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetRandomQuoteUseCaseTest {

    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        getRandomQuoteUseCase = GetRandomQuoteUseCase()
    }

    @Test
    fun `when database is empty return null`() {
        // Given
        QuoteProvider.quoteList = emptyList()

        // When
        val result = getRandomQuoteUseCase()

        // Then
        assertNull(result)
    }

    @Test
    fun `when database is not empty return quote`() {
        // Given
        val quoteList = listOf(QuoteModel("Hello world", "Aristotle"))
        QuoteProvider.quoteList = quoteList

        // When
        val result = getRandomQuoteUseCase()

        // Then
        assertNotNull(result)
        assertEquals("Hello world", result?.quote)
        assertEquals("Aristotle", result?.author)
    }

    @Test
    fun `when database has multiple quotes return one of them`() {
        // Given
        val quoteList = listOf(
            QuoteModel("Quote 1", "Author 1"),
            QuoteModel("Quote 2", "Author 2"),
            QuoteModel("Quote 3", "Author 3")
        )
        QuoteProvider.quoteList = quoteList

        // When
        val result = getRandomQuoteUseCase()

        // Then
        assertNotNull(result)
        assertTrue(quoteList.contains(result))
    }
}
