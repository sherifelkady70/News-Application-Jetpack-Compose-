package com.route.newsapplication.presentation.search

import androidx.paging.PagingData
import com.route.newsapplication.domain.models.Article

data class SearchState(
    val search : String ,
    val articles : PagingData<Article>
)
