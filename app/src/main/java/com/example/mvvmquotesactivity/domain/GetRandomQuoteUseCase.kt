package com.example.mvvmquotesactivity.domain

import com.example.mvvmquotesactivity.data.model.QuoteModel
import com.example.mvvmquotesactivity.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quoteList
        return getQuotes(quotes)
    }

    private fun getQuotes(quotes: List<QuoteModel>): QuoteModel? {
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}