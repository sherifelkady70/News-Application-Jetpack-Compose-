package com.route.newsapplication.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.presentation.home.components.ArticleCard
import com.route.newsapplication.util.Constants.ExtraSmallPadding
import com.route.newsapplication.util.Constants.MediumPadding1


@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles : LazyPagingItems<Article> ,
    onClick : (Article) -> Unit
){
    val handlePagingData = handlingPagingResult(articles = articles)
    Log.d("result of Api","handle paging data - boolean $handlePagingData")
    if(handlePagingData){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(ExtraSmallPadding),
        ) {
            items(count = articles.itemCount) {
                articles[it]?.let { articles ->
                    Log.d("result of Api","article item count $it")
                    ArticleCard(article = articles, onClick = { onClick })
                    Log.d("result of Api","articles passed into Article card  $articles")
                }
            }
        }
    }
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