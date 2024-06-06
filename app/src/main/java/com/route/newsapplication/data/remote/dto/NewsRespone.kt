package com.route.newsapplication.data.remote.dto

data class NewsRespone(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)