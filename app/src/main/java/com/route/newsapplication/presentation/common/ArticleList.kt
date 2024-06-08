package com.route.newsapplication.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
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
fun HandlingPagingResult(
    articles: LazyPagingItems<Article>
){

}


@Composable
fun ShimmerEffect(){

}