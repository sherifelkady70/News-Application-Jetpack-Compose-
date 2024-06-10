package com.route.newsapplication.domain.repository

import androidx.paging.PagingData
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.domain.models.Source
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources : List<String>) : Flow<PagingData<Article>>

    fun getSearchNews(search : String ,  sources : List<String> ) : Flow<PagingData<Article>>
}