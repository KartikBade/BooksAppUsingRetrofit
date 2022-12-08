package com.example.booksappusingretrofit.network

import com.squareup.moshi.Json

data class Items (
    @Json(name="items")
    val items: List<VolumeInfo>
    )