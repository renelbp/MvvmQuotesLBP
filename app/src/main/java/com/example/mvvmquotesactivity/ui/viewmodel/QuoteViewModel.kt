package com.example.mvvmquotesactivity.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmquotesactivity.data.model.QuoteModel
import com.example.mvvmquotesactivity.data.model.QuoteProvider
import com.example.mvvmquotesactivity.domain.GetQuotesUseCase
import com.example.mvvmquotesactivity.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCases = GetRandomQuoteUseCase()
    val quoteModel = MutableLiveData<QuoteModel>()
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