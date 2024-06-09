package com.route.newsapplication.presentation.home

data class HomeState(
    val newsTicker : String = "",
    val isLoading :Boolean= false
)
