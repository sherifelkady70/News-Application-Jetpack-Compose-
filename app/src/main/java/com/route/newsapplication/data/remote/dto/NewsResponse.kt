package com.route.newsapplication.data.remote.dto

import com.route.newsapplication.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)