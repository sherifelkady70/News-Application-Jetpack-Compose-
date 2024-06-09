package com.route.newsapplication.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.route.newsapplication.domain.models.Article

@Composable
fun HomeScreen(articles : LazyPagingItems<Article> , navigation : (String) -> Unit){

    val titles by remember {
        derivedStateOf {
            if(articles.itemCount > 10){
                articles.itemSnapshotList.items
                    .slice(IntRange(0,9))
            }
        }
    }
}