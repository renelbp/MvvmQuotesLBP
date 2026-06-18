package com.renelbp.quotesapp.quotes.domain

import com.renelbp.quotesapp.quotes.data.model.QuoteModel
import com.renelbp.quotesapp.quotes.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): com.renelbp.quotesapp.quotes.data.model.QuoteModel?{
        val quotes = _root_ide_package_.com.renelbp.quotesapp.quotes.data.model.QuoteProvider.quoteList
        return getQuotes(quotes)
    }

    private fun getQuotes(quotes: List<com.renelbp.quotesapp.quotes.data.model.QuoteModel>): com.renelbp.quotesapp.quotes.data.model.QuoteModel? {
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}