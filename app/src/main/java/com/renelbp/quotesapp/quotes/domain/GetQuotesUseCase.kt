package com.renelbp.quotesapp.quotes.domain

import com.renelbp.quotesapp.quotes.data.QuoteRepository
import com.renelbp.quotesapp.quotes.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository =
        _root_ide_package_.com.renelbp.quotesapp.quotes.data.QuoteRepository()
    suspend operator fun invoke(): List<com.renelbp.quotesapp.quotes.data.model.QuoteModel> {
        return repository.getAllQuotes()
    }
}