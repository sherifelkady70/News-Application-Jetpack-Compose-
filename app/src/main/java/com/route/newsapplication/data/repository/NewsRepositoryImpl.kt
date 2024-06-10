package com.route.newsapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.route.newsapplication.data.remote.NewsPagingSource
import com.route.newsapplication.data.remote.NewsWebService
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi : NewsWebService
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(10) ,
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi,
                    source = sources.joinToString( ",")
                )
            }
        ).flow
    }
}