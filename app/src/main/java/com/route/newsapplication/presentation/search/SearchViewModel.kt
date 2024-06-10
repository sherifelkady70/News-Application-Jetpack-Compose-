package com.route.newsapplication.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.route.newsapplication.domain.usecase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase : NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state : State<SearchState> = _state

    fun onEvent(event : SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery ->{

            }
            is SearchEvent.SearchNews -> {

            }
        }
    }
}