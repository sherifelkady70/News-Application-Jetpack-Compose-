package com.route.newsapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.util.Constants.MediumPadding1


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
    return when{
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }
        error != null -> {
            //Empty view
            false
        }
        else -> {
            true
        }
    }

}


@Composable
fun ShimmerEffect(){
    Column (verticalArrangement = Arrangement.spacedBy(MediumPadding1)){
        repeat(10){
            ArticleShimmerEffect(
                modifier = Modifier.padding(MediumPadding1)
            )
        }
    }
}