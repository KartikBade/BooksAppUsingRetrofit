package com.example.booksappusingretrofit

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.booksappusingretrofit.databinding.BookItemBinding
import com.example.booksappusingretrofit.network.VolumeInfo

class BooksAdapter: ListAdapter<VolumeInfo, BooksAdapter.BooksViewHolder>(DiffCallBack) {

    class BooksViewHolder(private val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(volumeInfo: VolumeInfo) {
            binding.volumeInfo = volumeInfo
            binding.executePendingBindings()
            binding.bookItemCard.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=${volumeInfo.volumeInfo.title}")
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(BookItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<VolumeInfo>() {
        override fun areItemsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
            return oldItem.volumeInfo == newItem.volumeInfo
        }

        override fun areContentsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
            return oldItem.volumeInfo.title == newItem.volumeInfo.title && oldItem.volumeInfo.authors == newItem.volumeInfo.authors
        }

    }
}