package com.route.newsapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.route.newsapplication.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val img : Int
)


val pages = listOf(
    Page("The Daily Scroll","", R.drawable.news),
    Page("The Best Daily News App","", R.drawable.onboarding2),
    Page("Good News Is Coming","", R.drawable.goodnewsiscoming),

    )