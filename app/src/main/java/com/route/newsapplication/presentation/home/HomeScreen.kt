package com.route.newsapplication.presentation.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.route.newsapplication.R
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.util.Constants.MediumPadding1

@Composable
fun HomeScreen(articles : LazyPagingItems<Article> , navigation : (String) -> Unit){

    val titles by remember {
        derivedStateOf {
            if(articles.itemCount > 10){
                articles.itemSnapshotList.items
                    .slice(IntRange(0,9))
                    .joinToString(" ") {it.title}
            }else{
                " "
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(painter = painterResource(id = R.drawable.logo_foreground),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(MediumPadding1)
        )
        
        Spacer(modifier = Modifier.padding(MediumPadding1))
    }
}