package com.example.booksappusingretrofit.network

import com.squareup.moshi.Json

data class Book(
    @Json(name="title")
    val title: String,
    @Json(name="authors")
    val authors: List<String> = listOf("-"),
    @Json(name="imageLinks")
    val imageLinks: ImageLinks = ImageLinks(imgUrl = "https://imgs.search.brave.com/JEJxsFyrQQQw_ZEzKd7z5rm1bm8Kjqi7WWC9VvPvkAk/rs:fit:800:500:1/g:ce/aHR0cHM6Ly9kYWIx/bm1zbHZ2bnRwLmNs/b3VkZnJvbnQubmV0/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDE1/LzEyLzE0NTA5NzMw/NDZ3b3JkcHJlc3Mt/ZXJyb3JzLnBuZw")
    )

data class ImageLinks (
    @Json(name = "thumbnail")
    val imgUrl: String
    )