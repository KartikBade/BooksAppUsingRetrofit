package com.example.booksappusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.booksappusingretrofit.databinding.ActivityMainBinding
import com.example.booksappusingretrofit.network.BooksApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.booksList.adapter = BooksAdapter()
        binding.searchButton.setOnClickListener {
            viewModel.loadBooks(binding.searchQueryTextview.text.toString())
        }
    }
}