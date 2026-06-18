package com.renelbp.quotesapp.quotes.data

import com.renelbp.quotesapp.quotes.data.model.QuoteModel
import com.renelbp.quotesapp.quotes.data.model.QuoteProvider
import com.renelbp.quotesapp.quotes.data.network.QuoteService

class QuoteRepository {
    private val api =
        _root_ide_package_.com.renelbp.quotesapp.quotes.data.network.QuoteService()
    suspend fun getAllQuotes(): List<com.renelbp.quotesapp.quotes.data.model.QuoteModel>{
        val response = api.getQuotes()
        _root_ide_package_.com.renelbp.quotesapp.quotes.data.model.QuoteProvider.quoteList = response
        return response
    }
}