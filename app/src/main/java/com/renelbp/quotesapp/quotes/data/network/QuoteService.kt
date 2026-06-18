package com.renelbp.quotesapp.quotes.data.network

import com.renelbp.quotesapp.quotes.core.RetrofitHelper
import com.renelbp.quotesapp.quotes.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = _root_ide_package_.com.renelbp.quotesapp.quotes.core.RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<com.renelbp.quotesapp.quotes.data.model.QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(_root_ide_package_.com.renelbp.quotesapp.quotes.data.network.QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}