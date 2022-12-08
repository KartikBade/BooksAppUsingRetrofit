package com.example.booksappusingretrofit

import android.widget.ImageView
import android.widget.TextView
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
        imageView.load(imageUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("resultStatus")
fun bindResultStatus(imageView: ImageView, status: ResultStatus) {
    if (status == ResultStatus.LOADING){
        imageView.visibility = ImageView.VISIBLE
    }
    else {
        imageView.visibility = ImageView.GONE
    }
}

@BindingAdapter("resultStatus")
fun bindResultStatus(textView: TextView, status: ResultStatus) {
    if (status == ResultStatus.NOT_FOUND){
        textView.visibility = ImageView.VISIBLE
    }
    else {
        textView.visibility = ImageView.GONE
    }
}