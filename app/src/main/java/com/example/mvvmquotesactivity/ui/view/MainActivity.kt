package com.example.mvvmquotesactivity.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvmquotesactivity.databinding.ActivityMainBinding
import com.example.mvvmquotesactivity.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private val quoteViewModel: QuoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            currentQuote?.let {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text = it.author
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