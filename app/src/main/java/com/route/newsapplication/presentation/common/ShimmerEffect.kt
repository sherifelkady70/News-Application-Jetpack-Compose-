package com.route.newsapplication.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.newsapplication.R
import com.route.newsapplication.util.Constants.MediumPadding1

@Composable
fun Modifier.shimmerEffect() : Modifier = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    background(colorResource(id = R.color.shimmer).copy(alpha))
}

@Preview(showBackground = true)
@Composable
fun ArticleShimmerEffect(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .height(96.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MediumPadding1)
                    .height(30.dp)
                    .shimmerEffect()
            )


            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(horizontal = MediumPadding1)
                        .height(15.dp)
                        .shimmerEffect()
                )
            }
        }
    }
}