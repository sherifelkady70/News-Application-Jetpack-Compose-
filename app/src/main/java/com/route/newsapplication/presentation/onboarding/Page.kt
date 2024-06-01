package com.route.newsapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.route.newsapplication.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val img : Int
)


val pages = listOf(
    Page("","", R.drawable.onboarding1),
    Page("","", R.drawable.onboarding2),
    Page("","", R.drawable.onboarding3),

    )