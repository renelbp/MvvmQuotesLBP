package com.renelbp.quotesapp.quotes.data.network

import com.renelbp.quotesapp.quotes.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("quotes")
    suspend fun getAllQuotes(): Response<List<com.renelbp.quotesapp.quotes.data.model.QuoteModel>>
}