package com.route.newsapplication.domain.usecase.news

import androidx.paging.PagingData
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews (private val newsRepo : NewsRepository) {
    operator fun invoke(sources : List<String>): Flow<PagingData<Article>>{
        return newsRepo.getNews(sources)
    }
}