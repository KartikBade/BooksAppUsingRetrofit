package com.example.booksappusingretrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksappusingretrofit.network.BooksApi
import com.example.booksappusingretrofit.network.VolumeInfo
import kotlinx.coroutines.launch

private const val TAG = "BooksViewModel"

enum class ResultStatus { FOUND, LOADING, NOT_FOUND }

class BooksViewModel: ViewModel() {

    private val _volumeInfo = MutableLiveData<List<VolumeInfo>>()
    val volumeInfo: LiveData<List<VolumeInfo>> = _volumeInfo

    private val _resultStatus = MutableLiveData(ResultStatus.FOUND)
    val resultStatus: LiveData<ResultStatus> = _resultStatus

    fun loadBooks(searchQuery: String) {
        viewModelScope.launch {
            try {
                _volumeInfo.value = emptyList()
                _resultStatus.value = ResultStatus.LOADING

                _volumeInfo.value = BooksApi.retrofitService.getBooks(searchQuery).items
                _volumeInfo.value?.let {
                    if (_volumeInfo.value!!.isEmpty()) {
                        _resultStatus.value = ResultStatus.NOT_FOUND
                    } else {
                        _resultStatus.value = ResultStatus.FOUND
                    }
                }
            } catch (e: Exception) {
                _volumeInfo.value = emptyList()
                _resultStatus.value = ResultStatus.NOT_FOUND
                Log.e(TAG, "loadBooks: Error fetching books: $e")
            }
        }
    }
}