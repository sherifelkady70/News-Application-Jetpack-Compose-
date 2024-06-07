package com.route.newsapplication.presentation.onboarding.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import coil.decode.ImageSource
import coil.request.ImageRequest
import com.route.newsapplication.R
import com.route.newsapplication.domain.models.Article
import com.route.newsapplication.domain.models.Source
import com.route.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun ArticleCard(
    modifier : Modifier = Modifier,
    article : Article,
    onClick : () -> Unit
    ) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.clickable { onClick }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(96.dp)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(5.dp)
                .height(96.dp)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_medium),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.text_medium)
                )
                Spacer(modifier = Modifier.width(6.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time), contentDescription = null,
                    modifier = Modifier.size(11.dp),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.text_medium)
                )
            }
        }
    }
}

@Composable
fun PreviewArticle() {
    NewsApplicationTheme {
        ArticleCard(
            article = Article(
                author = "",
                title = "Everything to Know About Bitcoin Pizza Day",
                description = "",
                url = "",
                urlToImage = "",
                publishedAt = "2024-05-20T13:20:00Z",
                content = "",
                source = Source(id = "wired", name = "Wired")
            )
        ) {

        }
    }
}
