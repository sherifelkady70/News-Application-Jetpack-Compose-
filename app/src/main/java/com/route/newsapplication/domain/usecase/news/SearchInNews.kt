package com.route.newsapplication.domain.usecase.news

import androidx.compose.material3.rememberTopAppBarState
import androidx.paging.PagingData
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchInNews @Inject constructor(
    private val newsRepository : NewsRepository
) {
     operator fun invoke(search : String , sources : List<String>) : Flow<PagingData<Article>> {
        return newsRepository.getSearchNews(search , sources)
    }

}