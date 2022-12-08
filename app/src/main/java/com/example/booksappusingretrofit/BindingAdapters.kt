package com.example.booksappusingretrofit

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.booksappusingretrofit.network.VolumeInfo

@BindingAdapter("bookListData")
fun bindBookList(recyclerView: RecyclerView, data: List<VolumeInfo>?) {
    val adapter = recyclerView.adapter as BooksAdapter
    adapter.submitList(data)
}

@BindingAdapter("imgUrl")
fun bindBookImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imageUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri)
    }
}