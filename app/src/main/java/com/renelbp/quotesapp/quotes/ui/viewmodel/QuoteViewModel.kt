package com.renelbp.quotesapp.quotes.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renelbp.quotesapp.quotes.data.model.QuoteModel
import com.renelbp.quotesapp.quotes.domain.GetQuotesUseCase
import com.renelbp.quotesapp.quotes.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {

    var getQuotesUseCase = _root_ide_package_.com.renelbp.quotesapp.quotes.domain.GetQuotesUseCase()
    var getRandomQuoteUseCases =
        _root_ide_package_.com.renelbp.quotesapp.quotes.domain.GetRandomQuoteUseCase()
    val quoteModel = MutableLiveData<com.renelbp.quotesapp.quotes.data.model.QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCases()
        quote?.let{
            quoteModel.postValue(it)
        }
        isLoading.postValue(false)
    }


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            try {
                val result = getQuotesUseCase()
                if(result.isNotEmpty()){
                    quoteModel.postValue(result[0])
                }
            } catch (e: Exception) {
                // Log or handle error here
            } finally {
                isLoading.postValue(false)
            }
        }
    }


}