package com.route.newsapplication.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.route.newsapplication.presentation.common.ArticleList
import com.route.newsapplication.presentation.navgraph.Route
import com.route.newsapplication.util.Constants

@Composable
fun SearchScreen(
    state : SearchState,
    event : (SearchEvent) -> Unit,
    navigate : (String) -> Unit
){

    Column(
        modifier = Modifier
            .padding(
                top = Constants.MediumPadding1,
                start = Constants.MediumPadding1,
                end = Constants.MediumPadding1
            )
            .statusBarsPadding()
    ) {
        com.route.newsapplication.presentation.common.SearchBar(
            text = state.search,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) }
        )
        Spacer(modifier = Modifier.padding(Constants.MediumPadding1))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles = articles , onClick = {navigate(Route.DetailsScreen.route)})
        }
    }
}