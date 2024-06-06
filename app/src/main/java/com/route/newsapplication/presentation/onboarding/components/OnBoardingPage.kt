package com.route.newsapplication.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.newsapplication.R
import com.route.newsapplication.presentation.onboarding.Page

@Composable
fun OnBoardingPage(
    page : Page,
    modifier : Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painterResource(id =page.img) , contentDescription = "image page",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = page.title,
            modifier = Modifier.padding(horizontal = 30.dp),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small))


        Text(text = page.description,modifier = Modifier.padding(horizontal = 30.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium))
    }
}
