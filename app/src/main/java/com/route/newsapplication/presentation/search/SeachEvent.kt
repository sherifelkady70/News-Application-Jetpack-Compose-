package com.route.newsapplication.presentation.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val search: String) : SearchEvent()
    data object SearchNews : SearchEvent()
}