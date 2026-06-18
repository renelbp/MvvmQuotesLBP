package com.renelbp.quotesapp.quotes.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.renelbp.quotesapp.databinding.ActivityQuotesBinding

class QuotesActivity : AppCompatActivity() {

    private val quoteViewModel: com.renelbp.quotesapp.quotes.ui.viewmodel.QuoteViewModel by viewModels()
    private lateinit var binding: ActivityQuotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            currentQuote?.let {
                binding.tvQuote.text = currentQuote.quote
                binding.tvAuthor.text = currentQuote.author
            }
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it ?: false
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()

        }

    }
}