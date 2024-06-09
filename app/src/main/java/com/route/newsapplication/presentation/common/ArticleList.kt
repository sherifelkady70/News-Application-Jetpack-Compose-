package com.route.newsapplication.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.route.newsapplication.domain.models.Article


@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles : Article ,
    onClick : (Article) -> Unit
){

}


@Composable
fun handlingPagingResult(
    articles: LazyPagingItems<Article>
) : Boolean{
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        else -> null
    }


}


@Composable
fun ShimmerEffect(){
    ArticleShimmerEffect()
}