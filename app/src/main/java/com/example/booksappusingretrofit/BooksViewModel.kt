package com.example.booksappusingretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksappusingretrofit.network.BooksApi
import com.example.booksappusingretrofit.network.VolumeInfo
import kotlinx.coroutines.launch

class BooksViewModel: ViewModel() {

    private val _volumeInfo = MutableLiveData<List<VolumeInfo>>()
    val volumeInfo: LiveData<List<VolumeInfo>> = _volumeInfo

    fun loadBooks(searchQuery: String) {
        viewModelScope.launch {
            _volumeInfo.value = BooksApi.retrofitService.getBooks(searchQuery).items
        }
    }
}