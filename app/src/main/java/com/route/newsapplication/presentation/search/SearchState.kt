package com.route.newsapplication.presentation.search

import androidx.paging.PagingData
import com.route.newsapplication.domain.models.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val search : String ="" ,
    val articles : Flow<PagingData<Article>>?=null
)
